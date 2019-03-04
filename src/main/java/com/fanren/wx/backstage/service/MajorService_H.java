package com.fanren.wx.backstage.service;

import com.fanren.wx.app.dao.MajorMapper;
import com.fanren.wx.app.pojo.Major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorService_H {
    @Autowired
    MajorMapper majorMapper;

    public List<Major> major_list(){
        return majorMapper.major_list();
    }

    public int major_number(){
        return majorMapper.major_number();
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

    public void update_major(Major major){
        majorMapper.update_major(major);
    }
}
