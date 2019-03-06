package com.fanren.wx.backstage.controller;

import com.fanren.wx.app.pojo.College;
import com.fanren.wx.backstage.service.CollegeService_H;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CollegeController_H {
    @Autowired
    CollegeService_H collegeService_H;

    @RequestMapping("/bin/college_list")
    @ResponseBody
    public List<College> college_list(){
        return collegeService_H.college_list();
    }

    @RequestMapping("/bin/college_number")
    @ResponseBody
    public long college_number(){
        return collegeService_H.college_number();
    }

    @RequestMapping("/bin/GetCollege")
    @ResponseBody
    public College GetCollege(String id){
        return collegeService_H.GetCollege(id);
    }

    @RequestMapping("/bin/deleteCollege")
    @ResponseBody
    public void deleteCollege(String collegeId){
        collegeService_H.deleteCollege(collegeId);
    }

    @RequestMapping("/bin/insertCollege")
    @ResponseBody
    public void insertCollege(College college){
        collegeService_H.insertCollege(college);
    }

    @RequestMapping("/bin/updateCollege")
    @ResponseBody
    public void updateCollege(College college) throws Exception {
        collegeService_H.updateCollege(college);
    }
}
