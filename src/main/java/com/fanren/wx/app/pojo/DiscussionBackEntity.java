package com.fanren.wx.app.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/7 18:51
 * @Description: Class
 * @version:
 */
@Getter@Setter
public class DiscussionBackEntity {

    private String title;
    private String auth;
    private String time;
    private int count;
    private String userimage;
}
