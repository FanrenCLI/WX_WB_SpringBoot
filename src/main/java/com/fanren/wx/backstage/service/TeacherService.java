package com.fanren.wx.backstage.service;

import com.fanren.wx.app.dao.TeacherMapper;
import com.fanren.wx.app.pojo.Teacher;
import com.fanren.wx.app.pojo.TeacherExample;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    public List<Teacher> teacher_list(){
        return null;
    }

    public Teacher GetTeacher(String id){
        return null;
    }

    public void teacher_delete(String id){;
    }

    public int teacher_number(){
        return 1;
    }

    public void teacher_insert(Teacher teacher){
    }

    public void teacher_update(Teacher teacher){
    }

    public List<Teacher> getTeacherInfo(String department,String curriculum,String name){

        TeacherExample teacherExample=new TeacherExample();
        TeacherExample.Criteria criteria=teacherExample.createCriteria();
        if(department!=null){
            criteria.andDepartmentEqualTo(department);
        }
        if(name!=null){
            criteria.andNameEqualTo(name);
        }
        if(curriculum!=null){
            criteria.andTeachCurriculumEqualTo(curriculum);
        }
        return teacherMapper.selectByExample(teacherExample);
    }
}
