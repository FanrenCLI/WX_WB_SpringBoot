package com.fanren.wx.app.controller;

import com.fanren.wx.app.pojo.Phone;
import com.fanren.wx.app.serivce.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/14 18:40
 * @Description: Class
 * @version:
 */
@RestController
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @GetMapping(value = "/phone")
    public List<Phone> getPhoneInfo(){
        return phoneService.getPhoneInfo();
    }
}
