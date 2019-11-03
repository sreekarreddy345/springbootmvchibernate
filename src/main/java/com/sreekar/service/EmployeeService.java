package com.sreekar.service;

import com.sreekar.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    public void addEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public void deleteEmployee(Integer employeeId);
    public void updateEmployee(Employee employee);

    public Employee getEmployee(Integer empId);
}
