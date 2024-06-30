package com.sirjdbc;

public class Course {
    private int courseId;
    private String courseName;
    private String departmentName;
    private int capacity;

    public Course() {
    }

    public Course(int courseId, String courseName, String departmentName, int capacity) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.departmentName = departmentName;
        this.capacity = capacity;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
