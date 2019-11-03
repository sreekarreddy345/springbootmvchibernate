package com.sreekar.entity;


import com.sreekar.pojo.Student;

import javax.persistence.*;

@Entity
@Table(name = "studentrecords")
public class StudentEntity {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "address")
    private String address;

    public StudentEntity() {
    }

    public StudentEntity(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Student convertToBean() {
        Student student = new Student();
        student.setId(id);
        student.setAddress(address);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        return student;
    }
}
