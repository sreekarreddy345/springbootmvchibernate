package com.sreekar.pojo;

import com.sreekar.entity.StudentEntity;

public class Student {

    int id;
    String firstName;
    String lastName;
    String address;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StudentEntity convertToEntity(){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(id);
        studentEntity.setAddress(address);
        studentEntity.setFirstName(firstName);
        studentEntity.setLastName(lastName);
        return studentEntity;
    }
}
