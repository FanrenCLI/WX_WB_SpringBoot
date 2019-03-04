package com.fanren.wx.backstage.service;

import com.fanren.wx.app.dao.StudentMapper;
import com.fanren.wx.app.pojo.Student;
import com.fanren.wx.app.pojo.StudentExample;
import com.fanren.wx.backstage.util.UpdateSelective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService_H {
    @Autowired
    StudentMapper studentMapper;

    public List<Student> student_list(){
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        return studentMapper.selectByExample(studentExample);
    }
    public long student_number(){
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        return studentMapper.countByExample(studentExample);
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

    public void updateStudent(Student student) throws Exception {
        Student stu = (Student) UpdateSelective.selectiveFun(student);
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andStudentIdEqualTo(student.getStudentId());
        studentMapper.updateByExampleSelective(stu,studentExample);
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
