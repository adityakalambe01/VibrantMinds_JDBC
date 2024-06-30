package com.june29_06_2024.entity;

public class Student {
    private int studentId;
    private String studentName;
    private String studentCity;
    private long studentMobileNumber;

    public Student() {
    }

    public Student(int studentId, String studentName, String studentCity, long studentMobileNumber) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentCity = studentCity;
        this.studentMobileNumber = studentMobileNumber;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCity() {
        return studentCity;
    }

    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }

    public long getStudentMobileNumber() {
        return studentMobileNumber;
    }

    public void setStudentMobileNumber(long studentMobileNumber) {
        this.studentMobileNumber = studentMobileNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNAme='" + studentName + '\'' +
                ", studentCity='" + studentCity + '\'' +
                ", studentMobileNumber=" + studentMobileNumber +
                '}';
    }
}
