package com.sirjdbc;

public class EmployeeMain {
    public static void main(String[] args) {
//        Employee employee = new Employee();
//        employee.setName("Alex Quinnen");
//        employee.setSalary(159357.25);
//
//        EmployeeDao emplDao = new EmployeeDao();
//        System.out.println(
//                emplDao.updateEmployee(employee)
//        );


//        System.out.println(
//                new EmployeeDao().findById(1)
//        );

        for (Employee employee : new EmployeeDao().allEmployees()){
            System.out.println(employee);
        }
    }
}
