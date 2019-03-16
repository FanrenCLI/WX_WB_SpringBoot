package com.fanren.wx.app.controller;

import com.fanren.wx.app.dao.BadworldMapper;
import com.fanren.wx.app.pojo.Badworld;
import com.fanren.wx.app.serivce.UpLoadContentService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/8 15:31
 * @Description: Class
 * @version:
 */
@RestController
public class UpLoadContent {


    @Autowired
    private BadworldMapper badworldMapper;

    @Autowired
    private UpLoadContentService upLoadContentService;
    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping(value = "/uploadContent")
    public String insertContent(@RequestParam(value = "title")String title,
                              @RequestParam(value = "auth")String auth,
                              @RequestParam(value = "content")String content,
                              @RequestParam(value = "userimage")String userimage){

        new Thread(()->{
            long a=mongoTemplate.count(new Query(),"discussion")+1;
            Calendar calendar=Calendar.getInstance();
            String time= calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DATE);
            String insertInfo="{count:"+a+",title:\'"+upLoadContentService.CheckSensitiveWord(title)+"\',auth:\'"
                    +auth+"\',time:\'"+time+"\',userimage:\'"+userimage+"\'}";
            mongoTemplate.insert(insertInfo,"discussion");
            String insertInfo1="{content:\'"+upLoadContentService.CheckSensitiveWord(content)+"\',userimage:\'"+
                    userimage+"\',role:1,auth:\'"+auth+"\'}";
            mongoTemplate.insert(insertInfo1,"topic"+a);
        }).start();

        return "success";
    }
}
