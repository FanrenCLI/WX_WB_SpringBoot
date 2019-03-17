package com.fanren.wx.backstage.controller;

import com.fanren.wx.app.pojo.Curriculum;
import com.fanren.wx.backstage.service.CurriculumService_H;
import net.sf.json.JSONArray;
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
    public String curriculum_list(){
        List<Curriculum> curricula = curriculumService_H.curriculum_list();
        JSONArray jsonArray = JSONArray.fromObject(curricula);
        String result = "{\"code\":0,\"ms\":\"\",\"count\":0,\"data\":"+jsonArray+"}";
        return result;
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

    @RequestMapping("/bin/GetCurriculum_string")
    @ResponseBody
    public String GetCurriculum_string(String name){
        Curriculum curriculum = curriculumService_H.GetCurriculum(name);
        JSONArray jsonArray = JSONArray.fromObject(curriculum);
        String result = "{\"code\":0,\"ms\":\"\",\"count\":0,\"data\":"+jsonArray+"}";
        return result;
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

    @RequestMapping("/bin/curriculum_delete_many")
    @ResponseBody
    public void curriculum_delete_many(String data){
        curriculumService_H.curriculum_delete_many(data);
    }
}
