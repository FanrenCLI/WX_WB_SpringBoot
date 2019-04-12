package com.fanren.wx.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/14 20:02
 * @Description: Class
 * @version:
 */
@RestController
public class Jxdg {

    @Autowired
    private MongoTemplate mongoTemplate;


    @GetMapping("/jxdg")
    public String getJxdgInfo(@RequestParam(value = "info")String info){
        return mongoTemplate.find(new Query(Criteria.where("collegeone").exists(true)),String.class,info).get(0);

    }
}
