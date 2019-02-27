package com.fanren.wx.backstage.controller;

import com.fanren.wx.app.pojo.College;
import com.fanren.wx.backstage.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CollegeController {
    @Autowired
    CollegeService collegeService;

    @RequestMapping("/bin/college_list")
    @ResponseBody
    public List<College> college_list(){
        return collegeService.college_list();
    }

    @RequestMapping("/bin/college_number")
    @ResponseBody
    public int college_number(){
        return collegeService.college_number();
    }

    @RequestMapping("/bin/GetCollege")
    @ResponseBody
    public College GetCollege(String id){
        return collegeService.GetCollege(id);
    }

    @RequestMapping("/bin/deleteCollege")
    @ResponseBody
    public void deleteCollege(String collegeId){
        collegeService.deleteCollege(collegeId);
    }

    @RequestMapping("/bin/insertCollege")
    @ResponseBody
    public void insertCollege(College college){
        collegeService.insertCollege(college);
    }

    @RequestMapping("/bin/updateCollege")
    @ResponseBody
    public void updateCollege(College college){
        collegeService.updateCollege(college);
    }
}
