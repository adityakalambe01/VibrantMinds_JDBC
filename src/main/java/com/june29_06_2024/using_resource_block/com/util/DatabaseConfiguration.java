package com.june29_06_2024.using_resource_block.com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConfiguration {
    public static Connection connection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","root");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(
                connection()
        );
    }
}
