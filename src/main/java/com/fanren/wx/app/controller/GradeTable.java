package com.fanren.wx.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: FanrenCLI
 * @Date: 2019/3/1 13:17
 * @Description: Class
 * @version:
 */
@RestController
public class GradeTable {

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping(value = "/grade")
    public String getStuGradeById(String id){
        String collection=id.substring(0,7);
        Query query=new Query(Criteria.where("stuid").is(id));
        Query query1=new Query(Criteria.where("name").is("curriculum"));
        String curr=mongoTemplate.find(query1,String.class,collection).get(0);
        String result=mongoTemplate.find(query,String.class,collection).get(0);
        //String result=mongoTemplate.findAll(String.class,collection).get(0);
        String info="{\"curr\":"+curr+",\"grade\":"+result+"}";
        return info;
    }

}
