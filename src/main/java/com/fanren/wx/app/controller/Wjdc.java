package com.fanren.wx.app.controller;


import com.fanren.wx.app.dao.WjdcBackEntity;
import com.fanren.wx.app.serivce.WjdcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/10 22:02
 * @Description: Class
 * @version:
 */
@RestController
public class Wjdc {

    @Autowired
    private WjdcService wjdcService;

    @GetMapping(value = "wjdc")
    public List<WjdcBackEntity> getKptest(@RequestParam(value = "count")int count){
        return wjdcService.getWJtest(count);
    }
}
