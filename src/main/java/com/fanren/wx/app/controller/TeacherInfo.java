package com.fanren.wx.app.controller;

import com.fanren.wx.app.pojo.Teacher;
import com.fanren.wx.backstage.service.TeacherService;
import com.fanren.wx.backstage.util.SpeechUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.ValidationEvent;
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
    public List<Teacher> getTeacherInfo(@RequestParam(value = "department",required = false) String department,
                                        @RequestParam(value = "curriculum",required = false) String curriculum,
                                        @RequestParam(value = "name",required = false) String name){
        System.out.println(department);
        System.out.println(curriculum);
        System.out.println(name);
        return  teacherService.getTeacherInfo(department,curriculum,name);
    }
}
