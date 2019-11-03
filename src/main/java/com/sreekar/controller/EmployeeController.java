package com.sreekar.controller;

import com.sreekar.pojo.Employee;
import com.sreekar.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public ModelAndView getEmployees() {
        List<Employee> employeeList = Collections.EMPTY_LIST;
        ModelAndView modelAndView = new ModelAndView();
        try {
            employeeList = employeeService.getAllEmployees();

        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.addObject("employeeList", employeeList);
        modelAndView.setViewName("employeeHome");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createEmployee() {
        ModelAndView modelAndView = new ModelAndView();
        Employee e = new Employee();
        modelAndView.addObject("employee", e);
        modelAndView.setViewName("addEmployee");

/*        try {
            employeeService.addEmployee(e);
            return "Employee Created with name - " + e.getFirstName();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Employee Creation Failed - " + ex.getMessage();
        }*/
        return modelAndView;
    }


    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee e) {

        try {
            if(e.getId()==null || e.getId()==0){
                employeeService.addEmployee(e);
            }else {
                employeeService.updateEmployee(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/list";
    }


    @RequestMapping(value = "/update/{empId}", method = RequestMethod.GET)
    public ModelAndView updateEmployee(@PathVariable Integer empId) {
        ModelAndView modelAndView = null;
        try {
            modelAndView = new ModelAndView();
            modelAndView.setViewName("addEmployee");
            Employee employee = employeeService.getEmployee(empId);
            modelAndView.addObject("employee", employee);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return modelAndView;
    }


    @RequestMapping(value = "/delete/{empId}", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable Integer empId) {
        try {
            employeeService.deleteEmployee(empId);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return "redirect:/list";
    }


}
