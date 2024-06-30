package com.june28_06_2024.Main;

import com.june28_06_2024.dao.StudentDao;
import com.june28_06_2024.entity.Students;

public class StudentMain {
    public static void main(String[] args) {
        Students students = new Students();
//        students.setName("Aditya Kalmabe");
//        students.setCity("Pune");
//        students.setPercentage(88.88);
//
        StudentDao studentDao = new StudentDao();
//        studentDao.createTable();
//        System.out.println(
//                studentDao.insertStudent(students)
//        );
//
//        System.out.println(
//                studentDao.deleteStudentById(1)
//        );
//
//        System.out.println(
//                studentDao.findStudentById(2)
//        );
//
//        for (Students stud : studentDao.findAllStudents()){
//            System.out.println(stud);
//        }

//        students.setName("Hitesh");
//        students.setCity("Pune");
//        students.setPercentage(98.88);
//        System.out.println(
//                studentDao.updateStudent(2, students)
//        );
//
//        System.out.println(
//                studentDao.findStudentById(2)
//        );

        students = studentDao.findStudentById(15);
        System.out.println(students);

        students.setPercentage(77.77);

        System.out.println(
                studentDao.updateStudent(students.getId(), students)
        );

        System.out.println(
                studentDao.findStudentById(students.getId())
        );

    }
}
