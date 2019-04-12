package com.fanren.wx.app.controller;

import com.fanren.wx.app.pojo.DiscussionBackEntity;
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
 * @Date: 2019/3/7 18:50
 * @Description: Class
 * @version:
 */
@RestController
public class Discussion {

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping(value = "/discussion")
    public List<DiscussionBackEntity> getDiscussionInfo(@RequestParam(value = "count") int  count){
        Query query= new Query(Criteria.where("count").gt(mongoTemplate.count(new Query(),"discussion")-count));
        List<DiscussionBackEntity> result=mongoTemplate.find(query,DiscussionBackEntity.class,"discussion");
        Collections.reverse(result);
        return result;
    }

    @GetMapping(value = "/searchTopicByInfo")
    public List<DiscussionBackEntity> searchTopicByInfo(@RequestParam(value = "info")String info){
        String regex1=".*"+info+".*";
        Criteria criteria=new Criteria();
        Query query=new Query(criteria.orOperator(Criteria.where("auth").regex(regex1),Criteria.where("title").regex(regex1)));
        List<DiscussionBackEntity> list=mongoTemplate.find(query,DiscussionBackEntity.class,"discussion");
        Collections.reverse(list);
        return list;
    }
}
