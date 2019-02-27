package com.fanren.wx.backstage.controller;

import com.fanren.wx.app.pojo.Teacher;
import com.fanren.wx.backstage.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @RequestMapping("/bin/teacher_list")
    @ResponseBody
    public List<Teacher> teacher_list(){
        return teacherService.teacher_list();
    }

    @RequestMapping("/bin/GetTeacher")
    @ResponseBody
    public Teacher GetTeacher(String id){
        return teacherService.GetTeacher(id);
    }

    @RequestMapping("/bin/teacher_delete")
    @ResponseBody
    public void teacher_delete(String id){
        teacherService.teacher_delete(id);
    }

    @RequestMapping("/bin/teacher_number")
    @ResponseBody
    public int teacher_number(){
        return teacherService.teacher_number();
    }

    @RequestMapping("/bin/teacher_insert")
    @ResponseBody
    public void teacher_insert(Teacher teacher){
        teacherService.teacher_insert(teacher);
    }

    @RequestMapping("/bin/teacher_update")
    @ResponseBody
    public void teacher_update(Teacher teacher){
        teacherService.teacher_update(teacher);
    }
}
