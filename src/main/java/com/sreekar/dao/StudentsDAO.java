package com.sreekar.dao;

import com.sreekar.entity.StudentEntity;
import com.sreekar.pojo.Student;

import java.util.List;

public interface StudentsDAO {
    public List<StudentEntity> getStudents();
    public void saveStudents(StudentEntity studententity);

}
