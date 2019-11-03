package com.sreekar.dao;

import com.sreekar.entity.EmployeeEntity;
import com.sreekar.pojo.Employee;

import java.util.List;

public interface EmployeeDao {

    public void addEmployee(EmployeeEntity employee);
    public List<EmployeeEntity> getAllEmployees();
    public void deleteEmployee(Integer employeeId);
    public void updateEmployee(EmployeeEntity employee);

    public EmployeeEntity getEmployee(Integer empId);
}
