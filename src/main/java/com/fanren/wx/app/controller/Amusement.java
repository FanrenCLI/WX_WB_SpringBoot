package com.fanren.wx.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/16 18:19
 * @Description: Class
 * @version:
 */
@RestController
public class Amusement {

    @Autowired
    private MongoTemplate mongoTemplate;


    @GetMapping(value = "/yule")
    public String getYuLeInfo(@RequestParam(value = "count1")int count1,
                              @RequestParam(value = "count2")int count2){

            Query query= new Query(Criteria.where("count").gt(mongoTemplate.count(new Query(),"biaobai")-count1));
            List<String> result=mongoTemplate.find(query,String.class,"biaobai");
            if(result.size()>0){
                Collections.reverse(result);
            }
            Query query1= new Query(Criteria.where("count").gt(mongoTemplate.count(new Query(),"happythings")-count2));
            List<String> result1=mongoTemplate.find(query1,String.class,"happythings");
            if(result1.size()>0){
                Collections.reverse(result1);
            }

        return "{\"content\":"+result+",\"happythings\":"+result1+"}";
    }
}
