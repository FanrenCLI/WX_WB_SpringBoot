package com.fanren.wx.backstage.controller;

import com.fanren.wx.app.pojo.Student;
import com.fanren.wx.backstage.service.StudentService_H;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController_H {
    @Autowired
    StudentService_H studentService_H;

    @RequestMapping("/bin/student_list")
    @ResponseBody
    public List<Student> student_list(){
        return studentService_H.student_list();
    }

    @RequestMapping("/bin/student_number")
    @ResponseBody
    public long student_number(){
        return studentService_H.student_number();
    }

    @RequestMapping("/bin/GetStudent")
    @ResponseBody
    public Student GetStudent(String id){
        Student student = studentService_H.GetStudent(id);
        return student;
    }

    @RequestMapping("/bin/insertStudent")
    @ResponseBody
    public void insertStudent(Student student){
        studentService_H.insertStudent(student);
    }

    @RequestMapping("/bin/deleteStudent")
    @ResponseBody
    public void deleteStudent(String studentId){
        System.out.println(studentId);
        studentService_H.deleteStudent(studentId);
    }

    @RequestMapping("/bin/updateStudent")
    @ResponseBody
    public void updateStudent(Student student) throws Exception {
        studentService_H.updateStudent(student);
    }
}
