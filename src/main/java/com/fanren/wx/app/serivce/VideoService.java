package com.fanren.wx.app.serivce;

import com.fanren.wx.app.pojo.VideoBackEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/10 13:48
 * @Description: Class
 * @version:
 */
@Service
public class VideoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<VideoBackEntity> getVideolist(int count){
        Query query=new Query(Criteria.where("count").gt(mongoTemplate.count(new Query(),"video")-count));
        List<VideoBackEntity> list= mongoTemplate.find(query,VideoBackEntity.class,"video");
        Collections.reverse(list);
        return list;
    }

    public List<VideoBackEntity> searchVideoByInfo(String info){

        String regex1=".*"+info+".*";
        Criteria criteria=new Criteria();
        Query query=new Query(criteria.orOperator(Criteria.where("auth").regex(regex1),Criteria.where("title").regex(regex1)));
        List<VideoBackEntity> list=mongoTemplate.find(query,VideoBackEntity.class,"video");
        Collections.reverse(list);
        return list;
    }
}
