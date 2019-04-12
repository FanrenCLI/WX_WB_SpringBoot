package com.fanren.wx.app.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/10 20:12
 * @Description: Class
 * @version:
 */
@Setter@Getter
public class JwtzBackEntity {
    private int count;
    private String title;
    private String auth;
    private String src;
    private String time;
}
