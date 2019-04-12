package com.fanren.wx.app.controller;

import com.fanren.wx.app.pojo.MessageBackEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/8 21:08
 * @Description: Class
 * @version:
 */
@RestController
public class SendMessage {


    @Autowired
    private MongoTemplate mongoTemplate;


    @GetMapping(value = "/message")
    public void InsertMessageIntoMongoDB(@RequestParam(value = "auth")String auth,
                                         @RequestParam(value = "content")String content,
                                         @RequestParam(value = "image")String image,
                                         @RequestParam(value = "count")String count){
        String insertinfo="{content:\'"+content+"\',userimage:\'"+image+"\',auth:\'"+auth+"\',role:2}";
        mongoTemplate.insert(insertinfo,count);
    }

    @GetMapping(value = "/getmessage")
    public List<MessageBackEntity> getMessage(@RequestParam(value = "count")String count){

        return mongoTemplate.find(new Query(),MessageBackEntity.class,count);
    }

}
