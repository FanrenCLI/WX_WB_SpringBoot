package com.fanren.wx.app.serivce;

import com.fanren.wx.app.dao.PhoneMapper;
import com.fanren.wx.app.pojo.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/14 18:56
 * @Description: Class
 * @version:
 */
@Service
public class PhoneService {

    @Autowired
    private PhoneMapper phoneMapper;

    public List<Phone> getPhoneInfo(){
        return phoneMapper.selectByExample(null);
    }
}
