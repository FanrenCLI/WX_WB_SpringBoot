package com.fanren.wx.backstage.controller;

import com.fanren.wx.app.pojo.Attend;
import com.fanren.wx.backstage.service.AttendService_H;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AttendController {
    @Autowired
    AttendService_H attendService_H;

    @RequestMapping("/bin/attend_list")
    @ResponseBody
    public List<Attend> attend_list(){
        return attendService_H.attend_list();
    }

    @RequestMapping("/bin/attend_insert")
    @ResponseBody
    public void attend_insert(Attend attend){
        attendService_H.attend_insert(attend);
    }

    @RequestMapping("/bin/GetAttend")
    @ResponseBody
    public Attend GetAttend(String id){
        return attendService_H.GetAttend(id);
    }

    @RequestMapping("/bin/attend_number")
    @ResponseBody
    public long attend_number(){
        return attendService_H.attend_number();
    }

    @RequestMapping("/bin/attend_delete")
    @ResponseBody
    public void attend_delete(String id){
        attendService_H.attend_delete(id);
    }

    @RequestMapping("/bin/attend_update")
    @ResponseBody
    public void attend_update(Attend attend){
        attendService_H.attend_update(attend);
    }
}
