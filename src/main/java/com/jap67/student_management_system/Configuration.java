package com.jap67.student_management_system;

public class Configuration {
    private int port;
    private String databaseName;
    private String username;
    private String password;


    public Configuration() {

    }

    public Configuration(int port, String databaseName, String username, String password) {
        this.port = port;
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
    }

    public String getLocalhost() {
        return  "jdbc:mysql://localhost:";
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
