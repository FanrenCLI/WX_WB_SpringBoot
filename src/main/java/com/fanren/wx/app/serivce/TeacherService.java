package com.fanren.wx.app.serivce;

import com.fanren.wx.app.dao.TeacherMapper;
import com.fanren.wx.app.pojo.Teacher;
import com.fanren.wx.app.pojo.TeacherExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/4 17:06
 * @Description: Class
 * @version:
 */
@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;


    public List<Teacher> getTeacherInfo(String department,String curriculum,String name){
        TeacherExample example=new TeacherExample();
        TeacherExample.Criteria criteria= example.createCriteria();
        if(department!=null){
            criteria.andDepartmentEqualTo(department);
        }
        if(curriculum!=null){
            criteria.andTeachCurriculumEqualTo(curriculum);
        }
        if(name!=null){
            criteria.andNameEqualTo(name);
        }
        return teacherMapper.selectByExample(example);
    }
}
