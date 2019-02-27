package com.fanren.wx.backstage.service;

import com.fanren.wx.app.dao.TeacherMapper;
import com.fanren.wx.app.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    public List<Teacher> teacher_list(){
        return teacherMapper.teacher_list();
    }

    public Teacher GetTeacher(String id){
        return teacherMapper.selectByPrimaryKey(id);
    }

    public void teacher_delete(String id){
        teacherMapper.deleteByPrimaryKey(id);
    }

    public int teacher_number(){
        return teacherMapper.teacher_number();
    }

    public void teacher_insert(Teacher teacher){
        teacherMapper.insert(teacher);
    }

    public void teacher_update(Teacher teacher){
        teacherMapper.teacher_update(teacher);
    }
}
