package com.fanren.wx.backstage.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fanren.wx.app.dao.AttendMapper;
import com.fanren.wx.app.pojo.Attend;
import com.fanren.wx.app.pojo.AttendExample;
import com.fanren.wx.backstage.util.UpdateSelective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendService_H {
    @Autowired
    AttendMapper attendMapper;

    public List<Attend> attend_list(){
        AttendExample attendExample = new AttendExample();
        AttendExample.Criteria criteria = attendExample.createCriteria();
        return attendMapper.selectByExample(attendExample);
    }

    public long attend_number(){
        AttendExample attendExample = new AttendExample();
        AttendExample.Criteria criteria = attendExample.createCriteria();
        return attendMapper.countByExample(attendExample);
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

    public void attend_update(Attend attend) throws Exception {
        AttendExample attendExample = new AttendExample();
        AttendExample.Criteria criteria = attendExample.createCriteria();
        criteria.andStudentIdEqualTo(attend.getStudentId());
        Attend o = (Attend)UpdateSelective.selectiveFun(attend);
        attendMapper.updateByExampleSelective(o,attendExample);
    }

    public void attend_delete_many(String data){
        JSONArray jsonArray = JSONArray.parseArray(data);
        for (int i=0;i<jsonArray.size();i++){
            JSONObject json = (JSONObject)jsonArray.get(i);
            attend_delete(json.getString("studentId"));
        }
    }

}
