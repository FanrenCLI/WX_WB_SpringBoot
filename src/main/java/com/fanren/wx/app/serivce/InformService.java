package com.fanren.wx.app.serivce;

import com.fanren.wx.app.pojo.JwtzBackEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/10 20:06
 * @Description: Class
 * @version:
 */
@Service
public class InformService {


    @Autowired
    private MongoTemplate mongoTemplate;

    public List<JwtzBackEntity> getInformlist(int count){

        Query query= new Query(Criteria.where("count").gt(mongoTemplate.count(new Query(),"jwtz")-count));
        List<JwtzBackEntity> result=mongoTemplate.find(query,JwtzBackEntity.class,"jwtz");
        Collections.reverse(result);
        return result;
    }

}
