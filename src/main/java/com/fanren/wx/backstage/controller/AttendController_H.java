package com.fanren.wx.backstage.controller;

import com.fanren.wx.app.pojo.Attend;
import com.fanren.wx.backstage.service.AttendService_H;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AttendController_H {
    @Autowired
    AttendService_H attendService_H;

    @RequestMapping("/bin/attend_list")
    @ResponseBody
    public String attend_list(){
        List<Attend> attends = attendService_H.attend_list();
        JSONArray jsonArray = JSONArray.fromObject(attends);
        String result = "{\"code\":0,\"ms\":\"\",\"count\":0,\"data\":"+jsonArray+"}";
        return result;
    }

    @RequestMapping("/bin/GetAttend_string")
    @ResponseBody
    public String GetAttend_string(String id){
        Attend attend = attendService_H.GetAttend(id);
        JSONArray jsonArray = JSONArray.fromObject(attend);
        String result = "{\"code\":0,\"ms\":\"\",\"count\":0,\"data\":"+jsonArray+"}";
        return result;
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

    @RequestMapping("/bin/attend_delete_many")
    @ResponseBody
    public void attend_delete_many(String data){
        attendService_H.attend_delete_many(data);
    }

    @RequestMapping("/bin/attend_update")
    @ResponseBody
    public void attend_update(Attend attend) throws Exception {
        attendService_H.attend_update(attend);
    }
}
