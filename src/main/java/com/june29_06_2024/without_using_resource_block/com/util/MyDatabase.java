package com.june29_06_2024.com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MyDatabase {
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/june29_06_2024", "root", "root");
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(PreparedStatement preparedStatement, Connection connection){
        try {
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void closeConnection(ResultSet resultSet, Connection connection){
        try {
            resultSet.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void closeConnection(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection){
        try {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
