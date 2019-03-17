package com.fanren.wx.backstage.service;

import com.fanren.wx.app.dao.StatisticMapper;
import com.fanren.wx.app.pojo.Statistic;
import com.fanren.wx.app.pojo.StatisticExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {
    @Autowired
    StatisticMapper statisticMapper;

    public List<Statistic> statistic_list(){
        StatisticExample statisticExample = new StatisticExample();
        return statisticMapper.selectByExample(statisticExample);
    }
}
