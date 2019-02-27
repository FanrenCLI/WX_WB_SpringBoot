package com.fanren.wx.backstage.service;

import com.fanren.wx.app.dao.StudentMapper;
import com.fanren.wx.app.pojo.Student;
import com.fanren.wx.app.pojo.StudentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    public List<Student> student_list(){
        return studentMapper.student_list();
    }
    public int student_number(){
        return studentMapper.student_number();
    }
    public Student GetStudent(String id){
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andStudentIdEqualTo(id);
        List<Student> students = studentMapper.selectByExample(studentExample);
        return students.get(0);
    }

    public void insertStudent(Student student){
        studentMapper.insert(student);
    }

    public void deleteStudent(String studentId){
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andStudentIdEqualTo(studentId);
        studentMapper.deleteByExample(studentExample);
    }

    public void updateStudent(Student student){
        studentMapper.updateStudent(student);
    }

}
