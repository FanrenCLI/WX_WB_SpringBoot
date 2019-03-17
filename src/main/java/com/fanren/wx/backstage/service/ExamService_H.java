package com.fanren.wx.backstage.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fanren.wx.app.dao.ExamMapper;
import com.fanren.wx.app.pojo.Exam;
import com.fanren.wx.app.pojo.ExamExample;
import com.fanren.wx.backstage.util.UpdateSelective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService_H {
    @Autowired
    ExamMapper examMapper;

    public List<Exam> exam_list(){
        ExamExample examExample = new ExamExample();
        return examMapper.selectByExample(examExample);
    }

    public Exam GetExam(String name){
        ExamExample examExample = new ExamExample();
        ExamExample.Criteria criteria = examExample.createCriteria();
        criteria.andNameEqualTo(name);
        return examMapper.selectByExample(examExample).get(0);
    }

    public void exam_insert(Exam exam){
        examMapper.insert(exam);
    }

    public long exam_number(){
        ExamExample examExample = new ExamExample();
        ExamExample.Criteria criteria = examExample.createCriteria();
        return examMapper.countByExample(examExample);
    }

    public void exam_update(Exam exam) throws Exception {
        ExamExample examExample = new ExamExample();
        ExamExample.Criteria criteria = examExample.createCriteria();
        criteria.andNameEqualTo(exam.getName());
        Exam e = (Exam) UpdateSelective.selectiveFun(exam);
        examMapper.updateByExampleSelective(e,examExample);
    }

    public void exam_delete(String name){
        ExamExample examExample = new ExamExample();
        ExamExample.Criteria criteria = examExample.createCriteria();
        criteria.andNameEqualTo(name);
        examMapper.deleteByExample(examExample);
    }

    public void exam_delete_many(String data){
        JSONArray jsonArray = JSONArray.parseArray(data);
        for (int i=0;i<jsonArray.size();i++){
            JSONObject json = (JSONObject)jsonArray.get(i);
            exam_delete(json.getString("name"));
        }
    }
}
