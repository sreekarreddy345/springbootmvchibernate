package com.sreekar.service;

import com.sreekar.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    void saveStudents(Student student);
}
