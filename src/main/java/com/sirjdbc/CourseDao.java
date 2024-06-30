package com.sirjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//complete database logic of course
public class CourseDao {
    private static Connection connection;
    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xyz","root","root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //New Course
    public int addNewCourse(Course course){
        int check = 0;
        String sql = "insert into course(name, dept_name, capacity) values(?,?,?)";
        try(PreparedStatement ptmt = connection.prepareStatement(sql)) {
            ptmt.setString(1, course.getCourseName());
            ptmt.setString(2, course.getDepartmentName());
            ptmt.setInt(3, course.getCapacity());

            check = ptmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return check;
    }




}
