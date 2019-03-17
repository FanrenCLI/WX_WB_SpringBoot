package com.fanren.wx.backstage.util;

import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileUtil {
    //静态方法：三个参数：文件的二进制，文件路径，文件名
    //通过该方法将在指定目录下添加指定文件
    public static void filedir(byte[] file, String filePath, String fileName) throws IOException {
        //目标目录
        File targetfile = new File(filePath);
        if(targetfile.exists()) {
            targetfile.mkdirs();
        }

        //二进制流写入
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    public static List<String> fileupload(MultipartFile file){
        List<String> liststr = new ArrayList<>();
        if(!file.isEmpty()) {
            // 获取文件名称,包含后缀
            String fileName = file.getOriginalFilename();
            String[] s = fileName.split("\\.");
            // 存放在这个路径下：该路径是该工程目录下的static文件下：(注：该文件可能需要自己创建)
            // 放在static下的原因是，存放的是静态文件资源，即通过浏览器输入本地服务器地址，加文件名时是可以访问到的
            String filepath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/";
            //String filepath = "http://39.105.26.229:8080/";
            String filename = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
            filename = filename + "." + s[1];
            try {
                // 该方法是对文件写入的封装，在util类中，导入该包即可使用，后面会给出方法
                FileUtil.filedir(file.getBytes(), filepath, filename);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            liststr.add(filepath);
            liststr.add(filename);
        }
        return liststr;
    }


}
