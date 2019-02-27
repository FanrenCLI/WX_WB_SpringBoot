package com.fanren.wx.backstage.service;

import com.fanren.wx.app.dao.ClassMapper;
import com.fanren.wx.app.pojo.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    ClassMapper classMapper;

    public List<Class> class_list(){
        return classMapper.class_list();
    }

    public int class_number(){
        return classMapper.class_number();
    }

    public Class GetClass(String id){
        return classMapper.selectByPrimaryKey(id);
    }

    public void class_delete(String id){
        classMapper.deleteByPrimaryKey(id);
    }

    public void class_insert(Class c){
        classMapper.insert(c);
    }

    public void class_update(Class c){
        classMapper.class_update(c);
    }
}
