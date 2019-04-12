package com.fanren.wx.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/16 21:27
 * @Description: Class
 * @version:
 */
@RestController
public class learnblock {

    @Autowired
    private MongoTemplate mongoTemplate;


    @GetMapping(value = "allinfo")
    public String getAllInfo(@RequestParam(value = "count")int count){
        Query query1= new Query(Criteria.where("count").gt(mongoTemplate.count(new Query(),"xszp")-count));
        List<String> result1=mongoTemplate.find(query1,String.class,"xszp");
        Collections.reverse(result1);
        Query query2= new Query(Criteria.where("count").gt(mongoTemplate.count(new Query(),"xwrd")-count));
        List<String> result2=mongoTemplate.find(query1,String.class,"xwrd");
        Collections.reverse(result1);
        Query query3= new Query(Criteria.where("count").gt(mongoTemplate.count(new Query(),"xshj")-count));
        List<String> result3=mongoTemplate.find(query1,String.class,"xshj");
        Collections.reverse(result1);
        Query query4= new Query(Criteria.where("count").gt(mongoTemplate.count(new Query(),"gwmx")-count));
        List<String> result4=mongoTemplate.find(query1,String.class,"gwmx");
        Collections.reverse(result1);
        return "{\"content0\":"+result1+",\"content1\":"+result2+",\"content2\":"+result3+",\"content3\":"+result4+"}";

    }
}
