package com.fanren.wx.app.serivce;

import com.fanren.wx.app.dao.AttendMapper;
import com.fanren.wx.app.dao.StudentMapper;
import com.fanren.wx.app.dao.TemplistMapper;
import com.fanren.wx.app.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/5 20:11
 * @Description: Class
 * @version:
 */
@Service
public class AttendService {
    @Autowired
    private AttendMapper attendMapper;
    @Autowired
    private TemplistMapper templistMapper;
    @Autowired
    private StudentMapper studentMapper;


    public List<Attend> getAttendInfo(String stuid){
        AttendExample example=new AttendExample();
        AttendExample.Criteria criteria=example.createCriteria();
        criteria.andStudentIdEqualTo(stuid);
        return attendMapper.selectByExample(example);
    }
    public void InsertTempInfo(Templist templist){

            templistMapper.insert(templist);

    }
    public List<Templist> CheckAttendInfo(String id,String classid){
        TemplistExample example=new TemplistExample();
        TemplistExample.Criteria criteria=example.createCriteria();
        criteria.andIdEqualTo(id).andClassidEqualTo(classid);
        return templistMapper.selectByExample(example);
    }
    public void UpdateInfo(Templist templist){
        TemplistExample example=new TemplistExample();
        TemplistExample.Criteria criteria=example.createCriteria();
        criteria.andIdEqualTo(templist.getId());
        templistMapper.updateByExample(templist,example);
    }
    //查询旷课学生信息
    public List<Attend> GetStudentAttendInfo(String code,String classid){
        Calendar calendar=Calendar.getInstance();
        String time= calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DATE);
        TemplistExample example=new TemplistExample();
        TemplistExample.Criteria criteria=example.createCriteria();
        criteria.andCodeEqualTo(code).andClassidEqualTo(classid).andRoleNotEqualTo(1);
        //本次上课所有签到学生列表
        List<Templist> list=templistMapper.selectByExample(example);
        //获取未签到学生
        List<String> stuid_list=new ArrayList<>();
        List<String> major_list=new ArrayList<>();
        for(Templist templist :list){
            stuid_list.add(templist.getId());
            major_list.add(templist.getMajor());
        }
        StudentExample example1=new StudentExample();
        StudentExample.Criteria criteria1=example1.createCriteria();
        criteria1.andStudentIdNotIn(stuid_list).andMajorIn(major_list);
        List<Student> list_1=studentMapper.selectByExample(example1);
        //剔除远程签到学生
        List<Attend> UnAttendStu_list=new ArrayList<>();
        TemplistExample example2=new TemplistExample();
        TemplistExample.Criteria criteria2=example2.createCriteria();
        criteria2.andRoleEqualTo(1).andCodeEqualTo(code).andClassidEqualTo(classid);
        List<Templist> list1=templistMapper.selectByExample(example2);
        Templist templist1=list1.get(0);
        //将运程签到学生加入列表
        for(Templist templist2:list){
            if(Math.abs(templist2.getLon()-templist1.getLon())>0.0002||Math.abs(templist2.getLat()-templist1.getLat())>0.0002){
                Attend attend=new Attend();
                attend.setStudentId(templist2.getId());
                attend.setClassName(classid);
                attend.setStudentName(templist2.getName());
                attend.setTime(time);
                UnAttendStu_list.add(attend);
            }
        }
        for(Student student :list_1){
            Attend attend=new Attend();
            attend.setStudentId(student.getStudentId());
            attend.setClassName(classid);
            attend.setStudentName(student.getName());
            attend.setTime(time);
            UnAttendStu_list.add(attend);
        }
        return UnAttendStu_list;
    }
}
