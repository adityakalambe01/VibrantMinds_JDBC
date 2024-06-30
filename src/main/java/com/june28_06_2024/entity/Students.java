package com.june28_06_2024.entity;

public class Students {
    private int id;
    private String name;
    private double percentage;
    private String city;

    public Students(int id, String name, double percentage, String city) {
        this.id = id;
        this.name = name;
        this.percentage = percentage;
        this.city = city;
    }

    public Students() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", percentage=" + percentage +
                ", city='" + city + '\'' +
                '}';
    }
}
