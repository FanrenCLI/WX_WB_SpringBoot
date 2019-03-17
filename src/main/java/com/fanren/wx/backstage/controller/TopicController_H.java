package com.fanren.wx.backstage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author: FanrenCLI
 * @Date: 2019/3/1 13:17
 * @Description: Class
 * @version:
 */
@RestController
public class TopicController_H {

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping(value = "/bin/topic_list")
    public List<String> Topic_list(){
        List<String> list = mongoTemplate.findAll(String.class,"discussion");
        return list;
    }

    @GetMapping(value = "/bin/GetTopic")
    public String GetTopic(String title){
        Query query = new Query(Criteria.where("title").is(title));
        mongoTemplate.find(query,String.class,"discussion");
        return mongoTemplate.find(query,String.class,"discussion").get(0);
    }

}
