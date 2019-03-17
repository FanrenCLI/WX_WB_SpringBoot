package com.fanren.wx.backstage.controller;

import com.fanren.wx.app.pojo.Exam;
import com.fanren.wx.backstage.service.ExamService_H;
import net.sf.json.JSONArray;
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
    public String exam_list(){
        List<Exam> exams = examService_H.exam_list();
        JSONArray jsonArray = JSONArray.fromObject(exams);
        String result = "{\"code\":0,\"ms\":\"\",\"count\":0,\"data\":"+jsonArray+"}";
        return result;
    }

    @RequestMapping("/bin/GetExam")
    @ResponseBody
    public Exam GetExam(String name){
        return examService_H.GetExam(name);
    }

    @RequestMapping("/bin/GetExam_string")
    @ResponseBody
    public String GetExam_string(String name){
        Exam exam = examService_H.GetExam(name);
        JSONArray jsonArray = JSONArray.fromObject(exam);
        String result = "{\"code\":0,\"ms\":\"\",\"count\":0,\"data\":"+jsonArray+"}";
        return result;
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

    @RequestMapping("/bin/exam_delete_many")
    @ResponseBody
    public void exam_delete_many(String data){
        examService_H.exam_delete_many(data);
    }
}
