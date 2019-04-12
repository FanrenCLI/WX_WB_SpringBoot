package com.fanren.wx.backstage.util;

import com.baidu.aip.imagecensor.AipImageCensor;
import org.json.JSONObject;

import java.io.File;

public class ImgCheckUtil {
    //设置APPID/AK/SK
    private static final String APP_ID = "15603691";
    private static final String API_KEY = "29sHNCAiH91YDOnwuyWHB6iu";
    private static final String SECRET_KEY = "9TQIolKt18TpUYaksxTCmwfyY8RM5ENt";
    /**
     * @param path 图片地址
     */
    public static String checkPornograp(String path) {
        if (!new File(path).exists()) {
            throw new NullPointerException("图片不存在");
        }
        // 初始化一个AipImageCensor
        AipImageCensor client = new AipImageCensor(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(4000);
        client.setSocketTimeoutInMillis(80000);
        // 调用接口
        JSONObject res = client.antiPorn(path);
        System.out.println(res.toString(2));
        return res.toString();
    }
}