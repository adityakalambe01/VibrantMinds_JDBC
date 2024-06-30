package com.june29_06_2024.dao;

import com.june29_06_2024.com.util.MyDatabase;

public class Table {
    public static void createStudentTable(){
        try {
            MyDatabase.getConnection().createStatement()
                    .execute(
                            "create table if not exists student(id int primary key auto_increment," +
                                    "name varchar(255)," +
                                    "city varchar(255)," +
                                    "mobilenumber decimal(10))"
                    );
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Table.createStudentTable();
    }
}
