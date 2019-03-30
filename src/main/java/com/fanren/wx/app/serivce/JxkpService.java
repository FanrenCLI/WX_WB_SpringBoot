package com.fanren.wx.app.serivce;

import com.fanren.wx.app.pojo.JxkpBackEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/10 21:36
 * @Description: Class
 * @version:
 */
@Service
public class JxkpService {
    @Autowired
    private MongoTemplate mongoTemplate;


    public List<JxkpBackEntity> getKPtest(int count){
        Query query= new Query(Criteria.where("count").gt(mongoTemplate.count(new Query(),"jxkp")-count));
        List<JxkpBackEntity> result=mongoTemplate.find(query,JxkpBackEntity.class,"jxkp");
        Collections.reverse(result);
        return result;
    }
}
