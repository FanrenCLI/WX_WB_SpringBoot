package com.fanren.wx.app.controller;

import com.fanren.wx.app.dao.JxkpBackEntity;
import com.fanren.wx.app.serivce.JxkpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/10 21:35
 * @Description: Class
 * @version:
 */
@RestController
public class Jxkp {

    @Autowired
    private JxkpService jxkpService;


    @GetMapping(value = "jxkp")
    public List<JxkpBackEntity> getKptest(@RequestParam(value = "count")int count){
        return jxkpService.getKPtest(count);
    }
}
