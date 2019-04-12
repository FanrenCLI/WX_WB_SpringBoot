package com.fanren.wx.app.dao;

import com.fanren.wx.app.pojo.Phone;
import com.fanren.wx.app.pojo.PhoneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhoneMapper {
    long countByExample(PhoneExample example);

    int deleteByExample(PhoneExample example);

    int insert(Phone record);

    int insertSelective(Phone record);

    List<Phone> selectByExample(PhoneExample example);

    int updateByExampleSelective(@Param("record") Phone record, @Param("example") PhoneExample example);

    int updateByExample(@Param("record") Phone record, @Param("example") PhoneExample example);
}