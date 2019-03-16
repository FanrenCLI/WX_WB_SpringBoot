package com.fanren.wx.app.controller;

import com.fanren.wx.app.pojo.Curriculum;
import com.fanren.wx.app.pojo.Kqclass;
import com.fanren.wx.app.pojo.Room;
import com.fanren.wx.app.pojo.RoomBackEntity;
import com.fanren.wx.app.serivce.CurriculumService;
import com.fanren.wx.app.serivce.KqclassService;
import com.fanren.wx.app.serivce.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/9 15:41
 * @Description: Class
 * @version:
 */
@RestController
public class LeisureRoom {

    @Autowired
    private CurriculumService curriculumService;
    @Autowired
    private KqclassService kqclassService;

    @Autowired
    private RoomService roomService;

    @GetMapping(value = "/leisureRoom")
    public List<Kqclass> getRoomList(@RequestParam(value = "xqj") int xqj){
        List<Kqclass> list2=new ArrayList<>();
        if(xqj>=6){
            list2 = kqclassService.getClassListAll();
        }else {
            List<Curriculum> list1 = curriculumService.getRoomList(String.valueOf(xqj));
            List<String> place = new ArrayList<>();
            for (Curriculum i : list1) {
                place.add(i.getKcdd());
            }
            list2 = kqclassService.getClassList(place);
        }
        List<RoomBackEntity> list3=roomService.getRoomList();
        Map<String,Integer> map=new HashMap<>();
        for(RoomBackEntity j:list3){
            map.put(j.getPlace(),j.getCount());
        }
        for(Kqclass m:list2){
            if(map.get(m.getPlace())==null){
                m.setNumber(0);
            }else{
                m.setNumber(map.get(m.getPlace()));
                m.setSeat(String.valueOf(Integer.valueOf(m.getSeat())-map.get(m.getPlace())));
            }
        }
        return list2;
    }

    @GetMapping(value = "/intoRoom")
    public String intoRoom(@RequestParam(value = "name")String name,
                         @RequestParam(value = "place")String place,
                         @RequestParam(value = "id")String id){
        Room room=new Room();
        room.setName(name);
        room.setPlace(place);
        room.setStuid(id);
        return roomService.intoRoom(room);
    }

    @GetMapping(value = "leaveRoom")
    public String leaveRoom(@RequestParam(value="id")String id,
                            @RequestParam(value = "place")String place){
        return roomService.leaveRoom(id,place);
    }







}
