package com.fanren.wx.backstage.service;

import com.fanren.wx.app.dao.TeacherMapper;
import com.fanren.wx.app.pojo.Teacher;
import com.fanren.wx.app.pojo.TeacherExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService_H {
    @Autowired
    TeacherMapper teacherMapper;

    public List<Teacher> teacher_list(){
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        return teacherMapper.selectByExample(teacherExample);
    }

    public Teacher GetTeacher(String id){
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria= teacherExample.createCriteria();
        criteria.andTeacherIdEqualTo(id);
        return teacherMapper.selectByExample(teacherExample).get(0);
    }

    public void teacher_delete(String id){
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andTeacherIdEqualTo(id);
        teacherMapper.deleteByExample(teacherExample);
    }

    public long teacher_number(){
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        return teacherMapper.countByExample(teacherExample);
    }

    public void teacher_insert(Teacher teacher){
        teacherMapper.insert(teacher);
    }

    public void teacher_update(Teacher teacher){
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andTeacherIdEqualTo(teacher.getTeacherId());
        teacherMapper.updateByExampleSelective(teacher,teacherExample);
    }
}
