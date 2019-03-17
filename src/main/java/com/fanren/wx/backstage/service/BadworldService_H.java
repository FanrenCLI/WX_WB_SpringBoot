package com.fanren.wx.backstage.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fanren.wx.app.dao.BadworldMapper;
import com.fanren.wx.app.pojo.Badworld;
import com.fanren.wx.app.pojo.BadworldExample;
import com.fanren.wx.backstage.util.BadWordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BadworldService_H {
    @Autowired
    BadworldMapper badworldMapper;

    public long badworld_number(){
        BadworldExample badworldExample = new BadworldExample();
        BadworldExample.Criteria criteria = badworldExample.createCriteria();
        return badworldMapper.countByExample(badworldExample);
    }

    public Badworld GetBadworld(String id){
        BadworldExample badworldExample = new BadworldExample();
        BadworldExample.Criteria criteria = badworldExample.createCriteria();
        criteria.andBadworldEqualTo(id);
        List<Badworld> badworlds = badworldMapper.selectByExample(badworldExample);
        return badworlds.get(0);
    }

    public void badworld_delete(String id){
        BadworldExample badworldExample = new BadworldExample();
        BadworldExample.Criteria criteria = badworldExample.createCriteria();
        criteria.andBadworldEqualTo(id);
        badworldMapper.deleteByExample(badworldExample);
    }

    public void badworld_insert(Badworld badworld){
        badworldMapper.insert(badworld);
    }

    public Set<String> badworld_exam(String data){
        return BadWordUtil.getBadWord(data,2);
    }

    public String badworld_filter(String data){
        return BadWordUtil.replaceBadWord(data,1,"*");
    }

    public Set<String> badworld_list(){
        BadworldExample badworldExample = new BadworldExample();
        List<Badworld> badworlds = badworldMapper.selectByExample(badworldExample);
        Set<String> result = new HashSet<>();
        for(int i=0;i<badworlds.size();i++){
            result.add(badworlds.get(i).getBadworld());
        }
        return result;
    }

    public void badworld_delete_many(String data){
        JSONArray jsonArray = JSONArray.parseArray(data);
        for (int i=0;i<jsonArray.size();i++){
            JSONObject json = (JSONObject)jsonArray.get(i);
            badworld_delete(json.getString("badworld"));
        }
    }
}
