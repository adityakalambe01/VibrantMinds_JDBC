package com.aditya;

import java.sql.*;

public class JDBCMain {
    static final String databaseUrl = "jdbc:mysql://localhost:3306/jap67";
    static final String username = "root";
    static final String password = "root";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseUrl, username, password);

            conn.createStatement().execute("create table if not exists cources(id int primary key auto_increment, name varchar(255))");
            conn.createStatement().execute("create table if not exists students(sid int primary key auto_increment, name varchar(255), cid int references cources(id))");

            String query = "insert into cources(name) values(?)";

            ps = conn.prepareStatement(query);
            ps.setString(1,"C++");

            System.out.println(
                    ps.executeUpdate()
            );

        }catch (ClassNotFoundException| SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
