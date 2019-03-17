package com.fanren.wx.backstage.controller;

import com.fanren.wx.app.pojo.Statistic;
import com.fanren.wx.backstage.service.StatisticService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatisticController {
    @Autowired
    StatisticService statisticService;

    @RequestMapping("/bin/statistic_list")
    public String statistic_list(){
        List<Statistic> data = statisticService.statistic_list();
        JSONArray jsonArray = JSONArray.fromObject(data);
        String result = "{\"code\":0,\"ms\":\"\",\"count\":0,\"data\":"+jsonArray+"}";
        return result;
    }
}
