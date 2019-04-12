package com.fanren.wx.app.serivce;


import com.fanren.wx.app.dao.RoomMapper;
import com.fanren.wx.app.pojo.Room;
import com.fanren.wx.app.pojo.RoomBackEntity;
import com.fanren.wx.app.pojo.RoomExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/9 16:10
 * @Description: Class
 * @version:
 */
@Service
public class RoomService {
    @Autowired
    private RoomMapper roomMapper;


    public List<RoomBackEntity> getRoomList(){
        return roomMapper.getRoomList();
    }


    public String intoRoom(Room room){
        RoomExample roomExample=new RoomExample();
        RoomExample.Criteria criteria=roomExample.createCriteria();
        criteria.andStuidEqualTo(room.getStuid());
        List<Room>list=roomMapper.selectByExample(roomExample);
        if(list.size()!=0){
            return list.get(0).getPlace();
        }else{
            roomMapper.insert(room);
            return "success";
        }
    }
    public String leaveRoom(String id,String place){
        RoomExample roomExample=new RoomExample();
        RoomExample.Criteria criteria=roomExample.createCriteria();
        criteria.andStuidEqualTo(id).andPlaceEqualTo(place);
        int i=roomMapper.deleteByExample(roomExample);
        if(i==0){
            return "fail";
        }else{
            return "success";
        }

    }
}
