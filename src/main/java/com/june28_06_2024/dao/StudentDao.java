package com.june28_06_2024.dao;

import com.june28_06_2024.entity.Students;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private static Connection connection = null;
    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap677","root","root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTable(){
        try {
            connection.createStatement().execute(
              "create table if not exists students(" +
                      "id int primary key auto_increment, " +
                      "name varchar(100), " +
                      "city varchar(100), " +
                      "percentage double(5,2))"
            );

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public int insertStudent(Students students){
        PreparedStatement pstmt = null;
        int check = 0;

        try {
//

            pstmt = connection.prepareStatement("insert into students(name, city, percentage) values (?,?,?)");
            pstmt.setString(1, students.getName());
            pstmt.setString(2, students.getCity());
            pstmt.setDouble(3, students.getPercentage());
            check = pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }

        return check;

    }

    public int deleteStudentById(int studentId){
        int check = 0;
        try {
            PreparedStatement ptmt = connection.prepareStatement("delete from students where id="+studentId);
            check = ptmt.executeUpdate();
            ptmt.close();
        }catch (SQLException | NullPointerException e){
            e.printStackTrace();
        }
        return check;
    }

    public Students findStudentById(int studentId){
        Students student = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select id, name, city, percentage from students where id=?");
            preparedStatement.setInt(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                student = new Students();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setCity(resultSet.getString("city"));
                student.setPercentage(resultSet.getDouble("percentage"));
            }

            resultSet.close();
            preparedStatement.close();

        }catch (SQLException | NullPointerException e){
            e.printStackTrace();
        }

        return student;
    }


    public int updateStudent(int studentId, Students updatedStudent){
        int check = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update students set name=?, city=?, percentage=? where id=?");

            preparedStatement.setString(1, updatedStudent.getName());
            preparedStatement.setString(2, updatedStudent.getCity());
            preparedStatement.setDouble(3, updatedStudent.getPercentage());
            preparedStatement.setInt(4, studentId);

            check = preparedStatement.executeUpdate();

        }catch (SQLException | NullPointerException e){
            e.printStackTrace();
        }

        return check;
    }

    public List<Students> findAllStudents(){
        List<Students> allStudent = new ArrayList<>();


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select id, name, city, percentage from students");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Students student = new Students();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setCity(resultSet.getString("city"));
                student.setPercentage(resultSet.getDouble("percentage"));
                allStudent.add(student);
            }

            resultSet.close();
            preparedStatement.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return allStudent;
    }

}
