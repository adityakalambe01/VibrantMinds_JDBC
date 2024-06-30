package com.sirjdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/khushbu","root","root");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int addNewEmployee(Employee employee){
        int check = 0;
        String query = "insert into employees(name, salary) values(?, ?)";
        try(PreparedStatement ptmt = connection.prepareStatement(query)) {
            ptmt.setString(1, employee.getName());
            ptmt.setDouble(2, employee.getSalary());

            check = ptmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return check;
    }

    public int updateEmployee(Employee employee){
        int check = 0;

        try(PreparedStatement preparedStatement = connection.prepareStatement("update employees set name=?, salary=? where id=?")) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDouble(2, employee.getSalary());
            preparedStatement.setInt(3, employee.getId());

            check = preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return check;
    }

    public Employee findById(int employeeId){
        Employee employee = null;
        String query = "select * from employees where id = ?";
        try(PreparedStatement ptmt = connection.prepareStatement(query)) {
            ptmt.setInt(1,employeeId);

            ResultSet resultSet = ptmt.executeQuery();

            while (resultSet.next()){
                employee = new Employee();
                employee.setId(
                        resultSet.getInt("id")
                );
                employee.setName(
                        resultSet.getString("name")
                );
                employee.setSalary(
                        resultSet.getDouble("salary")
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return employee;
    }

    public List<Employee> allEmployees(){

        List<Employee> employeeList = new ArrayList<>();
        String query = "select * from employees where id";
        try(PreparedStatement ptmt = connection.prepareStatement(query)) {

            ResultSet resultSet = ptmt.executeQuery();

            while (resultSet.next()){
                Employee employee = new Employee();
                employee.setId(
                        resultSet.getInt("id")
                );
                employee.setName(
                        resultSet.getString("name")
                );
                employee.setSalary(
                        resultSet.getDouble("salary")
                );
                employeeList.add(employee);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return employeeList;
    }
}
