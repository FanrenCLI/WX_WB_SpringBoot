package com.fanren.wx.backstage.controller;

import com.fanren.wx.app.pojo.Major;
import com.fanren.wx.backstage.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MajorController {
    @Autowired
    MajorService majorService;

    @RequestMapping("/bin/major_list")
    @ResponseBody
    public List<Major> major_list(){
        return majorService.major_list();
    }

    @RequestMapping("/bin/major_number")
    @ResponseBody
    public int major_number(){
        return majorService.major_number();
    }

    @RequestMapping("/bin/GetMajor")
    @ResponseBody
    public Major GetMajor(String id){
        return majorService.GetMajor(id);
    }

    @RequestMapping("/bin/Major_delete")
    @ResponseBody
    public void delete_Major(String majorID){
        majorService.delete_major(majorID);
    }

    @RequestMapping("/bin/insertMajor")
    @ResponseBody
    public void insertMajor(Major major){
        majorService.insertMajor(major);
    }

    @RequestMapping("/bin/updateMajor")
    @ResponseBody
    public void updateMajor(Major major){
        majorService.update_major(major);
    }
}
