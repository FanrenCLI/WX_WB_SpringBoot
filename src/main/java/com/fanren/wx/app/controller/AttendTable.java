package com.fanren.wx.app.controller;

import com.fanren.wx.app.pojo.Attend;
import com.fanren.wx.app.pojo.Templist;
import com.fanren.wx.app.serivce.AttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.AbstractList;
import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/5 20:10
 * @Description: Class
 * @version:
 */
@RestController
public class AttendTable {

    @Autowired
    private AttendService attendService;



    @GetMapping(value = "/attend")
    public List<Attend> getAttendInfoByStuid(@RequestParam(value = "stuid")String stuid){
        return attendService.getAttendInfo(stuid);
    }

    @GetMapping(value = "/attendInfo")
    public List<Attend> InserAttednInfo(@RequestParam(value = "code")String code,@RequestParam(value = "id") String id,
                                @RequestParam(value = "name") String name,@RequestParam(value = "role") String role,
                                @RequestParam(value = "classid") String classid,
                                @RequestParam(value = "lat") double lat,
                                @RequestParam(value = "lon") double lon,
                                  @RequestParam(value = "major")String major){
        Templist templist=new Templist();
        templist.setClassid(classid);
        templist.setCode(code);
        templist.setName(name);
        templist.setId(id);
        templist.setLat(lat);
        templist.setLon(lon);
        templist.setMajor(major);
        templist.setRole("教师".equals(role)?1:2);
        if("教师".equals(role)){
            List<Templist> list=attendService.CheckAttendInfo(id,classid);
            if(list.size()!=0){
                return attendService.GetStudentAttendInfo(code,classid);
            }else {
              attendService.InsertTempInfo(templist);
              return null;
            }
        }else {
            List<Templist> list=attendService.CheckAttendInfo(id,classid);
            if(list.size()!=0){
                attendService.UpdateInfo(templist);
                return null;
            }else{
                attendService.InsertTempInfo(templist);
                return null;
            }

        }
    }


}
