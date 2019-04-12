package com.fanren.wx.app.controller;

import com.fanren.wx.app.pojo.diningBackEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/4/12 10:41
 * @Description: Class
 * @version:
 */
@RestController
public class diningController {
    private static  int num=0;

    @Resource
    private MongoTemplate mongoTemplate;

    @GetMapping(value = "/dining")
    public String getdiningInfo(){
        List<String> result=mongoTemplate.findAll(String.class,"dining1");
        List<String> result1=mongoTemplate.findAll(String.class,"dining2");
        List<String> result2=mongoTemplate.findAll(String.class,"dining3");
        return "{\"result\":"+result+",\"result1\":"+ result1 +",\"result2\":"+result2+"}";

    }
    @GetMapping(value = "/surechoose")
    public String getNumInfo(@RequestParam(value = "id")String id){
        synchronized (this) {
            num++;
        }
        String info="{\"sutid\":"+id+",\"seatnum\":"+num+"}";
        mongoTemplate.insert(info,"diningTemplist");
        return String.valueOf(num);
    }
}
