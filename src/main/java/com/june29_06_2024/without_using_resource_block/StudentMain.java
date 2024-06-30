package com.june29_06_2024.without_using_resource_block;

import com.june29_06_2024.without_using_resource_block.dao.StudentDao;
import com.june29_06_2024.without_using_resource_block.dao.Table;
import com.june29_06_2024.without_using_resource_block.entity.Student;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StudentMain {
    public static void main(String[] args) {
        Table.createStudentTable();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StudentDao studentDao = new StudentDao();

/*        for (int i = 0; i < 5; i++) {
            try {
                Student student = new Student();
                System.out.print("Enter Name: ");
                student.setStudentName(bufferedReader.readLine());

                System.out.print("Enter City: ");
                student.setStudentCity(bufferedReader.readLine());

                System.out.print("Enter Mobile Number: ");
                student.setStudentMobileNumber(Long.parseLong(bufferedReader.readLine()));
                System.out.println(studentDao.insertStudent(student)==1?"Student added":"something went wrong");
            }catch (IOException e){
                e.printStackTrace();
            }
        }*/

/*        for (Student student : studentDao.getAllStudents()){
            System.out.println(student);
        }*/

        /*System.out.println(studentDao.findByStudentId(2));*/

/*        Student s = studentDao.findByStudentId(2);
        System.out.println(s);
        s.setStudentMobileNumber(1234567890);
        System.out.println(
                studentDao.updateStudent(2, s)
        );
        System.out.println(s);*/

/*        System.out.println(studentDao.deleteStudent(2));

        for (Student student : studentDao.getAllStudents()){
            System.out.println(student);
        }*/

        Student student = new Student();
        student.setStudentName("Rakesh");
        student.setStudentMobileNumber(15426333);
        student.setStudentCity("delhi");
        System.out.println(studentDao.insertStudent(student));
    }
}
