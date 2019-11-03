package com.sreekar.dao;

import com.sreekar.entity.EmployeeEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addEmployee(EmployeeEntity e) {
        sessionFactory.getCurrentSession().save(e);


    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return sessionFactory.getCurrentSession().createCriteria(EmployeeEntity.class).list();

    }

    @Override
    public void deleteEmployee(Integer id) {
        EmployeeEntity e = new EmployeeEntity();
        e.setId(id);
        sessionFactory.getCurrentSession().delete(e);
    }

    @Override
    public void updateEmployee(EmployeeEntity e) {
        sessionFactory.getCurrentSession().update(e);

    }

    @Override
    public EmployeeEntity getEmployee(Integer empId) {
        return sessionFactory.getCurrentSession().get(EmployeeEntity.class,empId);
    }
}
