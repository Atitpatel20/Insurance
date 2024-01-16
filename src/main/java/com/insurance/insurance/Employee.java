package com.insurance.insurance;

public class Employee {
    private String name;
    private int age;
    private String city;

    public String getName() {
        return name;
    }

    public Employee(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }
}
