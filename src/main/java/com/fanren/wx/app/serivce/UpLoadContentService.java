package com.fanren.wx.app.serivce;

import com.fanren.wx.app.dao.BadworldMapper;
import com.fanren.wx.app.pojo.Badworld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/8 16:19
 * @Description: Class
 * @version:
 */
@Service
public class UpLoadContentService {

    @Autowired
    private BadworldMapper badworldMapper;
    public String CheckSensitiveWord(String word){

        List<Badworld> list=badworldMapper.selectByExample(null);
        for(Badworld i:list){
            word.replace(i.getBadworld(),"***");
        }
        return word;
    }
}
