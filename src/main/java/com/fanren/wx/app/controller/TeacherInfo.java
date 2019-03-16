package com.fanren.wx.app.controller;

import com.alibaba.fastjson.JSONObject;
import com.fanren.wx.app.pojo.College;
import com.fanren.wx.app.pojo.Major;
import com.fanren.wx.app.pojo.Teacher;
import com.fanren.wx.app.serivce.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/3 19:37
 * @Description: Class
 * @version:
 */
@RestController
public class TeacherInfo {


    @Autowired
    private TeacherService teacherService;


    @GetMapping(value = "/teacher")
    public List<Teacher> getTeacherInfo(@RequestParam(value = "nameormajor") String nameormajor){

        return  teacherService.getTeacherInfo(nameormajor);
    }

    @GetMapping(value = "/departmentAndmajor")
    public String getDeptAndMajorInfo(){
        List<College> result1=teacherService.getCollegeInfo();
        List<Major> result2=teacherService.getMajorInfo();
        String json=JSONObject.toJSONString(result1);
        String json2=JSONObject.toJSONString(result2);
        return "{\"college\":"+json+",\"major\":"+json2+"}";
    }
}
