package com.fanren.wx.app.controller;

import com.fanren.wx.app.pojo.Curriculum;
import com.fanren.wx.app.pojo.CurriculumBackEntity;
import com.fanren.wx.app.serivce.CurriculumService;
import com.fanren.wx.app.util.HandlerClassses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author: FanrenCLI
 * @Date: 2019/2/28 20:39
 * @Description: Class
 * @version:
 */
@RestController
public class CurriculumTable {

    @Autowired
    private CurriculumService curriculumService;

    @GetMapping(value = "/curr")
    public List<CurriculumBackEntity> getCurriculumInfo(@RequestParam(value = "classes") String classes,
                                                        @RequestParam(value="major") String major){
        classes=HandlerClassses.MixClassesAndMajor(classes,major);
        List <Curriculum> curricula_list=curriculumService.getCurrInfo(classes);
        List<CurriculumBackEntity> result_list=new ArrayList<>();
        for(int i=0;i<curricula_list.size();i++){
            String len=curricula_list.get(i).getDayTime();
            String begin=len.substring(0,1);
            String end=len.substring(2);
            int a=Integer.parseInt(begin);
            int b=Integer.parseInt(end);
            CurriculumBackEntity result=new CurriculumBackEntity();
            result.setKcmc(curricula_list.get(i).getKcmc());
            result.setBg("");
            result.setZhouci(curricula_list.get(0).getZhouci());
            result.setSkbj(curricula_list.get(i).getSkbj());
            result.setSkcd(b-a+1);
            result.setTeacher(curricula_list.get(i).getTeachers());
            result.setSkjc(a);
            result.setXqj(Integer.parseInt(curricula_list.get(i).getWeekTime()));
            result.setSkdd(curricula_list.get(i).getKcdd());
            result_list.add(result);
        }
        return result_list;
    }
}
