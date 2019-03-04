package com.fanren.wx.backstage.service;

import com.fanren.wx.app.dao.ExamMapper;
import com.fanren.wx.app.pojo.Exam;
import com.fanren.wx.app.pojo.ExamExample;
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

    public void exam_update(Exam exam){
        ExamExample examExample = new ExamExample();
        ExamExample.Criteria criteria = examExample.createCriteria();
        criteria.andNameEqualTo(exam.getName());
        examMapper.updateByExampleSelective(exam,examExample);
    }

    public void exam_delete(String name){
        ExamExample examExample = new ExamExample();
        ExamExample.Criteria criteria = examExample.createCriteria();
        criteria.andNameEqualTo(name);
        examMapper.deleteByExample(examExample);
    }
}
