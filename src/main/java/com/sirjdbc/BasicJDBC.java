package com.sirjdbc;

//1 load the drive
//2 create a connection
//3 create query
//4 create statement
//5 execute statement
//6 close connections

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BasicJDBC {

    public static void createTable(){

        try {
            //step 1
            Class.forName("com.mysql.cj.jdbc.Driver");

            //step 2
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/khushbu","root","root");

            //step 3
            String query = "create table if not exists employees(id int primary key auto_increment, name varchar(255), salary double(8,2))";

            //step 4
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            //step 5
            preparedStatement.execute();


            //step 6
            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        createTable();
    }
}
