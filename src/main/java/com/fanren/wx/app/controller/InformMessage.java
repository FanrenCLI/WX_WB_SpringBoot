package com.fanren.wx.app.controller;

import com.fanren.wx.app.pojo.JwtzBackEntity;
import com.fanren.wx.app.serivce.InformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/10 20:06
 * @Description: Class
 * @version:
 */
@RestController
public class InformMessage {
    @Autowired
    private InformService informService;


    @GetMapping(value = "/jwtz")
    public List<JwtzBackEntity> getInformlist(@RequestParam(value = "count")int count){

        return informService.getInformlist(count);
    }
}
