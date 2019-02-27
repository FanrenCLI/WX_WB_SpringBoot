package com.fanren.wx.backstage.controller;

import com.fanren.wx.app.pojo.Curriculum;
import com.fanren.wx.backstage.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CurriculumController {
    @Autowired
    CurriculumService curriculumService;

    @RequestMapping("/bin/curriculum_list")
    @ResponseBody
    public List<Curriculum> curriculum_list(){
        return  curriculumService.curriculum_list();
    }

    @RequestMapping("/bin/curriculum_number")
    @ResponseBody
    public int curriculum_number(){
        return curriculumService.curriculum_number();
    }

    @RequestMapping("/bin/GetCurriculum")
    @ResponseBody
    public Curriculum GetCurriculum(String name){
        return curriculumService.GetCurriculum(name);
    }

    @RequestMapping("/bin/curriculum_insert")
    @ResponseBody
    public void curriculum_insert(Curriculum curriculum){
        curriculumService.curriculum_insert(curriculum);
    }

    @RequestMapping("/bin/curriculum_update")
    @ResponseBody
    public void curriculum_update(Curriculum curriculum){
        curriculumService.curriculum_update(curriculum);
    }

    @RequestMapping("/bin/curriculum_delete")
    @ResponseBody
    public void curriculum_delete(String name){
        curriculumService.curriculum_delete(name);
    }
}
