package com.sreekar.service;

import com.sreekar.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    Student getStudent(Integer id);
    void saveStudents(Student student);
}
