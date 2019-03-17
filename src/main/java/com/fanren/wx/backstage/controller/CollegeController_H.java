package com.fanren.wx.backstage.controller;

import com.fanren.wx.app.pojo.College;
import com.fanren.wx.backstage.service.CollegeService_H;
import net.sf.json.JSONArray;
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
    public String college_list(){
        List<College> colleges = collegeService_H.college_list();
        JSONArray jsonArray = JSONArray.fromObject(colleges);
        String result = "{\"code\":0,\"ms\":\"\",\"count\":0,\"data\":"+jsonArray+"}";
        return result;
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

    @RequestMapping("/bin/GetCollege_string")
    @ResponseBody
    public String GetCollege_string(String id){
        College college = collegeService_H.GetCollege(id);
        JSONArray jsonArray = JSONArray.fromObject(college);
        String result = "{\"code\":0,\"ms\":\"\",\"count\":0,\"data\":"+jsonArray+"}";
        return result;
    }

    @RequestMapping("/bin/deleteCollege")
    @ResponseBody
    public void deleteCollege(String id){
        collegeService_H.deleteCollege(id);
    }

    @RequestMapping("/bin/college_delete_many")
    @ResponseBody
    public void deleteCollege_many(String data){
        collegeService_H.college_delete_many(data);
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
