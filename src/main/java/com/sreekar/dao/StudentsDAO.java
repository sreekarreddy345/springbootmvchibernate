package com.sreekar.dao;

import com.sreekar.entity.StudentEntity;

import java.util.List;

public interface StudentsDAO {
    public List<StudentEntity> getStudents();

    public StudentEntity getStudent(Integer id);

    public void saveStudents(StudentEntity studententity);

}
