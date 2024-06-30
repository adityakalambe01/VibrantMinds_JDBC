package com.jap67.student_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Subjects {
    public static void addSubjects(int totalSubjects, Configuration cfg) {
        String localhostUrl = cfg.getLocalhost()+cfg.getPort()+"/"+cfg.getDatabaseName();
        String username = cfg.getUsername();
        String password = cfg.getPassword();
        Scanner myScanner = new Scanner(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(localhostUrl, username, password);
            for (int i = 0; i < totalSubjects; i++) {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into subject_master(code, subject_name, weightage) values(?, ?, ?)");

                System.out.print("Enter subject code: ");
                preparedStatement.setString(1, myScanner.nextLine());

                System.out.print("Enter subject name: ");
                preparedStatement.setString(2, myScanner.nextLine());

                System.out.print("Enter subject weightage: ");
                preparedStatement.setInt(3, myScanner.nextInt());
                System.out.println(preparedStatement.executeUpdate());
                preparedStatement.close();
                myScanner.nextLine();
            }
            System.out.println("Added " + totalSubjects + " subjects");

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void updateSubjects(Configuration cfg) {

    }
}
