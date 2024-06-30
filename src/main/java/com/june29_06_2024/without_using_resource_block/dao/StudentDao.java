package com.june29_06_2024.dao;

import com.june29_06_2024.com.util.MyDatabase;
import com.june29_06_2024.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public int insertStudent(Student student){
        int check = 0;
        Connection connection = MyDatabase.getConnection();
        PreparedStatement preparedStatement = null;

        try
        {
            preparedStatement = connection.prepareStatement("insert into student(name, city, mobilenumber) values (?,?,?)");
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setString(2, student.getStudentCity());
            preparedStatement.setLong(3, student.getStudentMobileNumber());
            check = preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MyDatabase.closeConnection(preparedStatement, connection);
        }
        return check;
    }

    public int updateStudent(int studentId, Student updatedStudent){
        int check = 0;
        Connection connection = MyDatabase.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update student set name=?, city=?, mobilenumber=? where id=?");
            preparedStatement.setString(1, updatedStudent.getStudentName());
            preparedStatement.setString(2, updatedStudent.getStudentCity());
            preparedStatement.setLong(3, updatedStudent.getStudentMobileNumber());
            preparedStatement.setInt(4, studentId);

            check = preparedStatement.executeUpdate();

        }catch (SQLException | NullPointerException e){
            e.printStackTrace();
        }finally {
            MyDatabase.closeConnection(preparedStatement, connection);
        }
        return check;
    }

    public int deleteStudent(int studentId){
        int check = 0;
        Connection connection = MyDatabase.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from student where id=?");
            preparedStatement.setInt(1, studentId);
            check = preparedStatement.executeUpdate();

        }catch (SQLException | NullPointerException e){
            e.printStackTrace();
        }finally {
            MyDatabase.closeConnection(preparedStatement, connection);
        }
        return check;
    }

    public Student findByStudentId(int studentId){
        Student student = null;
        Connection connection = MyDatabase.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select id, name, city, mobilenumber from student where id =?");
            preparedStatement.setInt(1, studentId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                student = new Student();
                student.setStudentId(resultSet.getInt("id"));
                student.setStudentName(resultSet.getString("name"));
                student.setStudentCity(resultSet.getString("city"));
                student.setStudentMobileNumber(resultSet.getLong("mobilenumber"));
            }

        }catch (SQLException | NullPointerException e){
            e.printStackTrace();
        }finally {
            MyDatabase.closeConnection(resultSet, preparedStatement, connection);
        }
        return student;
    }

    public List<Student> getAllStudents(){
        List<Student> allStudents = new ArrayList<>();
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = MyDatabase.getConnection();
            resultSet = connection.prepareStatement("select id, name, city, mobilenumber from student").executeQuery();

            while (resultSet.next()){
                allStudents.add(
                        new Student(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("city"),
                                resultSet.getLong("mobilenumber")
                        )
                );
            }
        }catch (SQLException | NullPointerException e){
            e.printStackTrace();
        }finally {
            MyDatabase.closeConnection(resultSet, connection);
        }
        return allStudents;
    }
}
