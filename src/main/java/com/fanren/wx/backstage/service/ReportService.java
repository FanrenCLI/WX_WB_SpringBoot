package com.fanren.wx.backstage.service;

import com.fanren.wx.app.dao.ReportMapper;
import com.fanren.wx.app.pojo.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    ReportMapper reportMapper;

    public List<Report> report_list(){
        return reportMapper.report_list();
    }

    public Report GetRepot(String id){
        return reportMapper.selectByPrimaryKey(id);
    }

    public void report_delete(String id){
        reportMapper.deleteByPrimaryKey(id);
    }

    public int report_number(){
        return  reportMapper.report_number();
    }

    public void report_insert(Report report){
        reportMapper.insert(report);
    }

    public void report_update(Report report){
        reportMapper.report_update(report);
    }
}
