package com.fanren.wx.app.controller;

import com.fanren.wx.app.pojo.Exam;
import com.fanren.wx.app.serivce.ExamService;
import com.fanren.wx.app.util.HandlerClassses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/6 17:32
 * @Description: Class
 * @version:
 */
@RestController
public class ExamTable {


    @Autowired
    private ExamService examService;

    @GetMapping(value = "/exam")
    public List<Exam> getExamInfo(@RequestParam(value = "classes")String classes,
                                  @RequestParam(value = "major") String major){

        return examService.getExamInfo(HandlerClassses.MixClassesAndMajor(classes,major));
    }
}
