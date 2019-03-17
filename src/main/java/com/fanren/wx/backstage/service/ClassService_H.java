package com.fanren.wx.backstage.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fanren.wx.app.dao.ClassMapper;
import com.fanren.wx.app.pojo.Class;
import com.fanren.wx.app.pojo.ClassExample;
import com.fanren.wx.backstage.util.UpdateSelective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService_H {
    @Autowired
    ClassMapper classMapper;

    public List<Class> class_list(){
        ClassExample classExample  = new ClassExample();
        return classMapper.selectByExample(classExample);
    }

    public long class_number(){
        ClassExample classExample  = new ClassExample();
        return classMapper.countByExample(classExample);
    }

    public Class GetClass(String id){
        ClassExample classExample = new ClassExample();
        ClassExample.Criteria criteria = classExample.createCriteria();
        criteria.andClassIdEqualTo(id);
        return classMapper.selectByExample(classExample).get(0);
    }

    public void class_delete(String id){
        ClassExample classExample = new ClassExample();
        ClassExample.Criteria criteria = classExample.createCriteria();
        criteria.andClassIdEqualTo(id);
        classMapper.deleteByExample(classExample);
    }

    public void class_insert(Class c){
        classMapper.insert(c);
    }

    public void class_update(Class c) throws Exception {
        ClassExample classExample = new ClassExample();
        ClassExample.Criteria criteria = classExample.createCriteria();
        criteria.andClassIdEqualTo(c.getClassId());
        Class o = (Class) UpdateSelective.selectiveFun(c);
        classMapper.updateByExampleSelective(o,classExample);
    }

    public void class_delete_many(String data){
        JSONArray jsonArray = JSONArray.parseArray(data);
        for (int i=0;i<jsonArray.size();i++){
            JSONObject json = (JSONObject) jsonArray.get(i);
            class_delete(json.getString("classId"));
        }
    }
}
