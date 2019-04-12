package com.fanren.wx.app.util;

/**
 * @Author: FanrenCLI
 * @Date: 2019/3/6 17:40
 * @Description: Class
 * @version:
 */
public class HandlerClassses {


    public static String MixClassesAndMajor(String classes,String Major){
        String result =new String();
        switch (Major){
            case "地理信息科学":
                 result="地信"+classes;
                break;
            case "软件工程":
                result="软工"+classes;
                break;
        }


        return result;
    }
}
