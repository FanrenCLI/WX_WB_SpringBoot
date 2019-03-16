package com.fanren.wx.app.serivce;

import com.fanren.wx.app.dao.CollegeMapper;
import com.fanren.wx.app.dao.MajorMapper;
import com.fanren.wx.app.dao.TeacherMapper;
import com.fanren.wx.app.pojo.*;
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
    @Autowired
    private CollegeMapper collegeMapper;
    @Autowired
    private MajorMapper majorMapper;

    public List<Teacher> getTeacherInfo(String nameormajor){

        return teacherMapper.getTeacherInfoByNameOrCurr(nameormajor);
    }

    public List<College> getCollegeInfo(){
        CollegeExample example=new CollegeExample();

        return collegeMapper.selectByExample(example);
    }
    public List<Major> getMajorInfo(){
        MajorExample example=new MajorExample();
        return majorMapper.selectByExample(example);
    }
}
