package com.fanren.wx.backstage.controller;

import com.fanren.wx.app.pojo.Student;
import com.fanren.wx.backstage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/bin/student_list")
    @ResponseBody
    public List<Student> student_list(){
        return studentService.student_list();
    }

    @RequestMapping("/bin/student_number")
    @ResponseBody
    public int student_number(){
        return studentService.student_number();
    }

    @RequestMapping("/bin/GetStudent")
    @ResponseBody
    public Student GetStudent(String id){
        Student student = studentService.GetStudent(id);
        return student;
    }

    @RequestMapping("/bin/insertStudent")
    @ResponseBody
    public void insertStudent(Student student){
        studentService.insertStudent(student);
    }

    @RequestMapping("/bin/deleteStudent")
    @ResponseBody
    public void deleteStudent(String studentId){
        System.out.println(studentId);
        studentService.deleteStudent(studentId);
    }

    @RequestMapping("/bin/updateStudent")
    @ResponseBody
    public void updateStudent(Student student){
        studentService.updateStudent(student);
    }
}
