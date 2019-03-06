package com.fanren.wx.backstage.controller;

import com.fanren.wx.app.pojo.Class;
import com.fanren.wx.backstage.service.ClassService_H;
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
    public List<Class> class_list(){
        return classService_H.class_list();
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

    @RequestMapping("/bin/class_delete")
    @ResponseBody
    public void class_delete(String id){
        classService_H.class_delete(id);
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
