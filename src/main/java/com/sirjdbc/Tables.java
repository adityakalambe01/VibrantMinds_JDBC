package com.sirjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Tables {
    private static Connection connection;
    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xyz","root","root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    {
        try {
            connection.createStatement().execute("create table if not exists course(id int primary key auto_increment, name varchar(255), dept_name varchar(255), capacity int)");
            System.out.println("Table created!!!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
