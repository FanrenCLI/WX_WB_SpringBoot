package com.fanren.wx.backstage.service;

import com.fanren.wx.app.dao.CollegeMapper;
import com.fanren.wx.app.pojo.College;
import com.fanren.wx.app.pojo.CollegeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {
    @Autowired
    CollegeMapper collegeMapper;
    public List<College> college_list(){
        return collegeMapper.college_list();
    }
    public int college_number(){
        return collegeMapper.college_number();
    }
    public College GetCollege(String id){
        CollegeExample collegeExample = new CollegeExample();
        CollegeExample.Criteria criteria = collegeExample.createCriteria();
        criteria.andCollegeIdEqualTo(id);
        List<College> colleges = collegeMapper.selectByExample(collegeExample);
        return colleges.get(0);
    }
    public void deleteCollege(String id){
        collegeMapper.deleteByPrimaryKey(id);
    }
    public void insertCollege(College college){
        collegeMapper.insert(college);
    }

    public void updateCollege(College college){
        collegeMapper.college_update(college);
    }
}
