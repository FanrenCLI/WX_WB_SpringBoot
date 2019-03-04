package com.fanren.wx.backstage.controller;

import com.fanren.wx.app.pojo.Report;
import com.fanren.wx.backstage.service.ReportService_H;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ReportController_H {
    @Autowired
    ReportService_H reportService_H;

    @RequestMapping("/bin/report_list")
    @ResponseBody
    public List<Report> report_list(){
        return reportService_H.report_list();
    }

    @RequestMapping("/bin/GetReport")
    @ResponseBody
    public Report GetReport(String id){
        return reportService_H.GetRepot(id);
    }

    @RequestMapping("/bin/report_delete")
    @ResponseBody
    public void report_delete(String id){
        reportService_H.report_delete(id);
    }

    @RequestMapping("/bin/report_number")
    @ResponseBody
    public int report_number(){
        return reportService_H.report_number();
    }

    @RequestMapping("/bin/report_insert")
    @ResponseBody
    public void report_insert(Report report){
        reportService_H.report_insert(report);
    }

    @RequestMapping("/bin/report_update")
    @ResponseBody
    public void report_update(Report report){
        reportService_H.report_update(report);
    }
}
