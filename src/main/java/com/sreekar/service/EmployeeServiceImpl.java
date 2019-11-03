package com.sreekar.service;

import com.sreekar.dao.EmployeeDao;
import com.sreekar.entity.EmployeeEntity;
import com.sreekar.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public EmployeeEntity convertBeanToEntity(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employee.getId());
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeEntity.setAge(employee.getAge());
        employeeEntity.setCity(employee.getCity());

        return employeeEntity;
    }

    public Employee convertEntityToBean(EmployeeEntity employee) {
        Employee employeeEntity = new Employee();
        employeeEntity.setId(employee.getId());
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeEntity.setAge(employee.getAge());
        employeeEntity.setCity(employee.getCity());

        return employeeEntity;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> allEmployees = employeeDao.getAllEmployees();
        List<Employee> employees = new ArrayList<>();
        for (EmployeeEntity employeeEntity : allEmployees
        ) {
            employees.add(convertEntityToBean(employeeEntity));
        }

        return employees;

    }

    @Override
    public void addEmployee(Employee employee) {
        EmployeeEntity employeeEntity = convertBeanToEntity(employee);
        employeeDao.addEmployee(employeeEntity);

    }

    @Override
    public void deleteEmployee(Integer employeeId) {

        employeeDao.deleteEmployee(employeeId);
    }

    @Override
    public void updateEmployee(Employee employee) {
        EmployeeEntity employeeEntity = convertBeanToEntity(employee);
        employeeDao.updateEmployee(employeeEntity);
    }

    @Override
    public Employee getEmployee(Integer empId) {
         EmployeeEntity employee = employeeDao.getEmployee(empId);
         return convertEntityToBean(employee);

    }
}
