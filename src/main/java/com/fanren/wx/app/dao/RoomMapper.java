package com.fanren.wx.app.dao;

import com.fanren.wx.app.pojo.Room;
import com.fanren.wx.app.pojo.RoomBackEntity;
import com.fanren.wx.app.pojo.RoomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoomMapper {

    List <RoomBackEntity> getRoomList();
    long countByExample(RoomExample example);

    int deleteByExample(RoomExample example);

    int insert(Room record);

    int insertSelective(Room record);

    List<Room> selectByExample(RoomExample example);

    int updateByExampleSelective(@Param("record") Room record, @Param("example") RoomExample example);

    int updateByExample(@Param("record") Room record, @Param("example") RoomExample example);
}