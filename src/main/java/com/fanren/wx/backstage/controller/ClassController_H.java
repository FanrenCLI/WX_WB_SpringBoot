package com.fanren.wx.backstage.controller;

import com.fanren.wx.app.pojo.Class;
import com.fanren.wx.backstage.service.ClassService_H;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ClassController_H {
    @Autowired
    ClassService_H classService_H;

    @RequestMapping("/bin/class_list")
    @ResponseBody
    public String class_list(){
        List<Class> classes = classService_H.class_list();
        JSONArray jsonArray = JSONArray.fromObject(classes);
        String result = "{\"code\":0,\"ms\":\"\",\"count\":0,\"data\":"+jsonArray+"}";
        return result;
    }

    @RequestMapping("/bin/class_number")
    @ResponseBody
    public long class_number(){
        return classService_H.class_number();
    }

    @RequestMapping("/bin/GetClass")
    @ResponseBody
    public Class GetClass(String id){
        return classService_H.GetClass(id);
    }

    @RequestMapping("/bin/GetClass_string")
    @ResponseBody
    public String GetClass_string(String id){
        Class aClass = classService_H.GetClass(id);
        JSONArray jsonArray = JSONArray.fromObject(aClass);
        String result = "{\"code\":0,\"ms\":\"\",\"count\":0,\"data\":"+jsonArray+"}";
        return result;
    }

    @RequestMapping("/bin/class_delete")
    @ResponseBody
    public void class_delete(String id){
        classService_H.class_delete(id);
    }

    @RequestMapping("/bin/class_delete_many")
    @ResponseBody
    public void class_delete_many(String data){
        classService_H.class_delete_many(data);
    }

    @RequestMapping("/bin/class_insert")
    @ResponseBody
    public void class_insert(Class c){
        classService_H.class_insert(c);
    }

    @RequestMapping("/bin/class_update")
    @ResponseBody
    public void class_update(Class c) throws Exception {
        classService_H.class_update(c);
    }
}
