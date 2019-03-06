package com.fanren.wx.backstage.service;

import com.fanren.wx.app.dao.CollegeMapper;
import com.fanren.wx.app.pojo.College;
import com.fanren.wx.app.pojo.CollegeExample;
import com.fanren.wx.backstage.util.UpdateSelective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService_H {
    @Autowired
    CollegeMapper collegeMapper;
    public List<College> college_list(){
        CollegeExample collegeExample = new CollegeExample();
        return collegeMapper.selectByExample(collegeExample);
    }
    public long college_number(){
        CollegeExample collegeExample = new CollegeExample();
        return collegeMapper.countByExample(collegeExample);
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

    public void updateCollege(College college) throws Exception {
        CollegeExample collegeExample = new CollegeExample();
        CollegeExample.Criteria criteria = collegeExample.createCriteria();
        criteria.andCollegeIdEqualTo(college.getCollegeId());
        College o = (College) UpdateSelective.selectiveFun(college);
        collegeMapper.updateByExample(o,collegeExample);
    }
}
