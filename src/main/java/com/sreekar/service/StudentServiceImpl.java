package com.sreekar.service;

import com.sreekar.dao.StudentsDAO;
import com.sreekar.entity.StudentEntity;
import com.sreekar.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentsDAO studentsDAO;

    @Override
    public List<Student> getStudents() {

        List<StudentEntity> students = studentsDAO.getStudents();
        List<Student> studentList = new ArrayList<>();
        for (StudentEntity studentEntity: students){
            studentList.add(studentEntity.convertToBean());
        }
        return studentList;
    }

    @Override
    public void saveStudents(Student student) {

        studentsDAO.saveStudents(student.convertToEntity());
    }
}
