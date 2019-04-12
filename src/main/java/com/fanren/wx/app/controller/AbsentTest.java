package com.fanren.wx.app.controller;

import com.fanren.wx.app.pojo.Attend;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/4/9 19:30
 * @Description: Class
 * @version:
 */
@RestController
public class AbsentTest {
    @GetMapping("/attendtest")
    public List<Attend> TestBack(@RequestParam(value = "testinfo") int nums){
        List<Attend> list=new ArrayList<>();
        if(nums%2==0){
            System.out.println("success");
            list.add(new Attend("1622022000","zhangsan","161","2019-1-12"));
            return list;
        }else{
            System.out.println("fail");
            return null;
        }
    }
}
