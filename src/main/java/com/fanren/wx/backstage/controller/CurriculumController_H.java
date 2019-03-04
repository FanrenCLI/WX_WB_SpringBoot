package com.fanren.wx.backstage.controller;

import com.fanren.wx.app.pojo.Curriculum;
import com.fanren.wx.backstage.service.CurriculumService_H;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CurriculumController_H {
    @Autowired
    CurriculumService_H curriculumService_H;

    @RequestMapping("/bin/curriculum_list")
    @ResponseBody
    public List<Curriculum> curriculum_list(){
        return  curriculumService_H.curriculum_list();
    }

    @RequestMapping("/bin/curriculum_number")
    @ResponseBody
    public long curriculum_number(){
        return curriculumService_H.curriculum_number();
    }

    @RequestMapping("/bin/GetCurriculum")
    @ResponseBody
    public Curriculum GetCurriculum(String name){
        return curriculumService_H.GetCurriculum(name);
    }

    @RequestMapping("/bin/curriculum_insert")
    @ResponseBody
    public void curriculum_insert(Curriculum curriculum){
        curriculumService_H.curriculum_insert(curriculum);
    }

    @RequestMapping("/bin/curriculum_update")
    @ResponseBody
    public void curriculum_update(Curriculum curriculum) throws Exception {
        curriculumService_H.curriculum_update(curriculum);
    }

    @RequestMapping("/bin/curriculum_delete")
    @ResponseBody
    public void curriculum_delete(String name){
        curriculumService_H.curriculum_delete(name);
    }
}
