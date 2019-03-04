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


    /** 刘浩你的方法写在上面 下面的方法我写！！！！！！！！！！！！！！！！！！！！！！
    * @Author: FanrenCLI
    * @Date: 19:43 2019/2/28
    * @param: null
    * @Description: Method
    */
    public Student selectStudentById(String id){
        StudentExample studentExample=new StudentExample();
        StudentExample.Criteria criteria=studentExample.createCriteria();
        criteria.andStudentIdEqualTo(id);
        Student result=studentMapper.selectByExample(studentExample).get(0);
        return result;
    }
}
