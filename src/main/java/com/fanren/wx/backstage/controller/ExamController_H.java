package com.fanren.wx.backstage.controller;

import com.fanren.wx.app.pojo.Exam;
import com.fanren.wx.backstage.service.ExamService_H;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ExamController_H {
    @Autowired
    ExamService_H examService_H;

    @RequestMapping("/bin/exam_list")
    @ResponseBody
    public List<Exam> exam_list(){
        return examService_H.exam_list();
    }

    @RequestMapping("/bin/GetExam")
    @ResponseBody
    public Exam GetExam(String name){
        return examService_H.GetExam(name);
    }

    @RequestMapping("/bin/exam_insert")
    @ResponseBody
    public void exam_insert(Exam exam){
        examService_H.exam_insert(exam);
    }

    @RequestMapping("/bin/exam_number")
    @ResponseBody
    public long exam_number(){
        return examService_H.exam_number();
    }

    @RequestMapping("/bin/exam_update")
    @ResponseBody
    public void exam_update(Exam exam) throws Exception {
        examService_H.exam_update(exam);
    }

    @RequestMapping("/bin/exam_delete")
    @ResponseBody
    public void exam_delete(String name){
        examService_H.exam_delete(name);
    }
}
