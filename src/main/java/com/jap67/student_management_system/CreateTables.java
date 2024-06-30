package com.jap67.student_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateTables {
    public static boolean createNewTables(Configuration cfg){
        String query1 = "create table if not exists students_info(" +
                "reg_number int primary key auto_increment," +
                "student_name varchar(30) not null," +
                "contact_number decimal(10) unique check (contact_number>=1000000000)," +
                "date_of_birth date not null check ( date_of_birth<sysdate() )," +
                "date_of_joining datetime default now()," +
                "address varchar(255)," +
                "email_id varchar(255))";

        String query2 = "create table if not exists subject_master(" +
                "code varchar(10) primary key, " +
                "subject_name varchar(255) not null unique , " +
                "weightage decimal(3) not null)";

        String query3 = "create table if not exists students_marks(" +
                "stud_reg_number int references students_info(reg_number), " +
                "subject_code varchar(10) references subject_master(code), " +
                "semester decimal(3) not null , " +
                "marks int default 0 check( marks>=0 and marks<=100 ))";

        String query4 = "create table if not exists student_result(" +
                "stud_reg_number int references students_info(reg_number)," +
                "semester decimal(3) not null, " +
                "gpa decimal(1) not null default 0 check ( gpa<=4 and gpa>=0 ), " +
                "is_eligible_scholarship char(1) default 'Y', " +
                "primary key (stud_reg_number, semester))";

        String localhost = cfg.getLocalhost()+cfg.getPort()+"/"+cfg.getDatabaseName();
        String username = cfg.getUsername();
        String password = cfg.getPassword();


        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection(localhost, username, password);

            System.out.println("Connected to "+cfg.getDatabaseName());
            connection.createStatement().execute(query1);
            System.out.println("students_info table created!!!");

            connection.createStatement().execute(query2);
            System.out.println("subject_master table created!!!");

            connection.createStatement().execute(query3);
            System.out.println("students_marks table created!!!");

            connection.createStatement().execute(query4);
            System.out.println("student_result table created!!!");

            return true;

        }catch (ClassNotFoundException | SQLException e){

        }


        return false;
    }
}
