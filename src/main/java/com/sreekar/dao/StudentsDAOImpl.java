package com.sreekar.dao;

import com.sreekar.entity.StudentEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentsDAOImpl implements StudentsDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<StudentEntity> getStudents() {
        return sessionFactory.getCurrentSession().createCriteria(StudentEntity.class).list();
    }

    @Override
    public StudentEntity getStudent(Integer id) {
        return sessionFactory.getCurrentSession().get(StudentEntity.class, id);

    }

    @Override
    public void saveStudents(StudentEntity student) {
        sessionFactory.getCurrentSession().save(student);
    }
}
