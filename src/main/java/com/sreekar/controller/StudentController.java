package com.sreekar.controller;

import com.sreekar.pojo.Student;
import com.sreekar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/getStudents", method = RequestMethod.GET)
    public ModelAndView getStudents() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentsHome");
        return modelAndView;
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<Student> students() {
        return studentService.getStudents();
    }


    @RequestMapping(value = "/createStudent", method = RequestMethod.GET)
    public ModelAndView createStudent() {
        ModelAndView modelAndView = new ModelAndView();
//        Student student = new Student();
//        modelAndView.addObject("student", student);
        modelAndView.setViewName("addStudent");

        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public String saveEmployee(@RequestBody Student student) {

        try {
            studentService.saveStudents(student);
            return "Student Created Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Student Creation Failed with an exception - " + e;
        }

    }

}
