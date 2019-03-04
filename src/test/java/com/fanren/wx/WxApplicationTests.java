package com.fanren.wx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WxApplicationTests {

    @Autowired
    MongoTemplate mongoTemplate;
    @Test
    public void contextLoads() {

        String sss="{name:'12',asda:1223}";
        mongoTemplate.insert(sss,"test");
//        List<String> result=mongoTemplate.findAll(String.class,"1622022");
//        System.out.println(result.get(0));
    }

}

