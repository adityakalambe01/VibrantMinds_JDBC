package com.jap67.student_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CreateDatabase {
    public static boolean createNewDatabase(String newDatabaseName, Configuration cfg) {
        String localhostUrl = cfg.getLocalhost()+cfg.getPort()+"/"+cfg.getDatabaseName();
        String username = cfg.getUsername();
        String password = cfg.getPassword();
        String query = "create database if not exists "+newDatabaseName;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(localhostUrl, username, password);

//            connection.createStatement().execute("drop database if exists "+newDatabaseName);
            connection.createStatement().execute(query);
            System.out.println(newDatabaseName+" database created!!!");
            return true;

        }catch (ClassNotFoundException | SQLException e){

        }

        return false;
    }
}
