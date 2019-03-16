package com.fanren.wx.app.serivce;

import com.fanren.wx.app.dao.KqclassMapper;
import com.fanren.wx.app.pojo.Kqclass;
import com.fanren.wx.app.pojo.KqclassExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/9 15:54
 * @Description: Class
 * @version:
 */
@Service
public class KqclassService {

    @Autowired
    private KqclassMapper kqclassMapper;


    public List<Kqclass> getClassList(List<String> place){
        KqclassExample example=new KqclassExample();
        KqclassExample.Criteria criteria=example.createCriteria();
        criteria.andPlaceNotIn(place);
        return kqclassMapper.selectByExample(example);
    }
    public List<Kqclass> getClassListAll(){
        return kqclassMapper.selectByExample(null);
    }
}
