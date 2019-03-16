package com.fanren.wx.app.serivce;

import com.fanren.wx.app.dao.JxkpBackEntity;
import com.fanren.wx.app.dao.WjdcBackEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/10 22:03
 * @Description: Class
 * @version:
 */
@Service
public class WjdcService {
    @Autowired
    private MongoTemplate mongoTemplate;


    public List<WjdcBackEntity> getWJtest(int count){
        Query query= new Query(Criteria.where("count").gt(mongoTemplate.count(new Query(),"wjdc")-count));
        List<WjdcBackEntity> result=mongoTemplate.find(query,WjdcBackEntity.class,"wjdc");
        Collections.reverse(result);
        return result;
    }
}
