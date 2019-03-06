package com.fanren.wx.backstage.service;

import com.fanren.wx.app.dao.MajorMapper;
import com.fanren.wx.app.pojo.Major;
import com.fanren.wx.app.pojo.MajorExample;
import com.fanren.wx.backstage.util.UpdateSelective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorService_H {
    @Autowired
    MajorMapper majorMapper;

    public List<Major> major_list(){
        MajorExample majorExample = new MajorExample();
        return majorMapper.selectByExample(majorExample);
    }

    public long major_number(){
        MajorExample majorExample = new MajorExample();
        return majorMapper.countByExample(majorExample);
    }

    public Major GetMajor(String id){
        return majorMapper.selectByPrimaryKey(id);
    }

    public void delete_major(String majorID){
        majorMapper.deleteByPrimaryKey(majorID);
    }

    public void insertMajor(Major major){
        majorMapper.insert(major);
    }

    public void update_major(Major major) throws Exception {
        MajorExample majorExample = new MajorExample();
        MajorExample.Criteria criteria = majorExample.createCriteria();
        criteria.andMajorIdEqualTo(major.getMajorId());
        Major m = (Major)UpdateSelective.selectiveFun(major);
        majorMapper.updateByExampleSelective(m,majorExample);
    }
}
