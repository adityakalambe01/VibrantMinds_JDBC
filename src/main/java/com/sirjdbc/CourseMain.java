package com.sirjdbc;

public class CourseMain {
    public static void main(String[] args) {
        Course course = new Course();
        course.setCourseName("Python");
        course.setCapacity(66);
        course.setDepartmentName("Fus Fus");


        CourseDao courseDao = new CourseDao();

//        System.out.println(
//                courseDao.addNewCourse(course)
//        );
    }
}
