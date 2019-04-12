package com.fanren.wx.app.controller;

import com.fanren.wx.app.pojo.Resource;
import com.fanren.wx.app.serivce.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Source;
import java.util.Collections;
import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/11 17:21
 * @Description: Class
 * @version:
 */
@RestController
public class DownLoadFile {

    @Autowired
    private ResourceService resourceService;

    @GetMapping(value = "/downloadurl")
    public List<Resource> getResourceList(){
        List<Resource> list=resourceService.getResourceList();
        Collections.reverse(list);
        return list;
    }

    @GetMapping(value = "/searchResourceByInfo")
    public List<Resource> searchResourceByinfo(@RequestParam(value = "info")String info){
        String result="%"+info+"%";
        return resourceService.searchResourceByInfo(result);
    }













}
