package com.fanren.wx.app.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/8 22:03
 * @Description: Class
 * @version:
 */
@Setter@Getter
public class MessageBackEntity {
    private String content;
    private String userimage;
    private String auth;
    private int role;
}
