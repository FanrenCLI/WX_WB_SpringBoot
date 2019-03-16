package com.fanren.wx.app.controller;

import com.fanren.wx.app.pojo.VideoBackEntity;
import com.fanren.wx.app.serivce.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/10 13:47
 * @Description: Class
 * @version:
 */
@RestController
public class VideoInfo {
    @Autowired
    private VideoService videoService;

    @GetMapping(value = "/video")
    public List<VideoBackEntity> getVideoInfo(@RequestParam(value = "count") int count){
        return videoService.getVideolist(count);
    }

    @GetMapping(value = "/searchVideoByInfo")
    public List<VideoBackEntity> SearchVideoByInfo(@RequestParam(value = "info") String info){

        return videoService.searchVideoByInfo(info);
    }
}
