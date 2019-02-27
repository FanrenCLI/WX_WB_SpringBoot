package com.fanren.wx.backstage.service;

import com.fanren.wx.app.dao.AttendMapper;
import com.fanren.wx.app.pojo.Attend;
import com.fanren.wx.app.pojo.AttendExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendService {
    @Autowired
    AttendMapper attendMapper;

    public List<Attend> attend_list(){
        return attendMapper.attend_list();
    }

    public int attend_number(){
        return attendMapper.attend_number();
    }

    public void attend_insert(Attend attend){
        attendMapper.insert(attend);
    }

    public Attend GetAttend(String id){
        AttendExample attendExample = new AttendExample();
        AttendExample.Criteria criteria = attendExample.createCriteria();
        criteria.andStudentIdEqualTo(id);
        List<Attend> attends = attendMapper.selectByExample(attendExample);
        return attends.get(0);
    }

    public void attend_delete(String id){
        AttendExample attendExample = new AttendExample();
        AttendExample.Criteria criteria = attendExample.createCriteria();
        criteria.andStudentIdEqualTo(id);
        attendMapper.deleteByExample(attendExample);
    }

    public void attend_update(Attend attend){
        attendMapper.attend_update(attend);
    }

}
