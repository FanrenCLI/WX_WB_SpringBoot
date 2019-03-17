package com.fanren.wx.backstage.service;

import com.alibaba.fastjson.JSONObject;
import com.fanren.wx.backstage.util.FtpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@Service
public class WjdcService_H {
    @Autowired
    MongoTemplate mongoTemplate;

    public String wjdcList(){
        List<String> data = mongoTemplate.findAll(String.class,"wjdc");
        String result = "{\"wjdc\":"+data+"}";
        return result;
    }

    public String Getwjdc(String name){
        Query query = new Query(Criteria.where("title").is(name));
        String result = "{\"wjdc\":"+mongoTemplate.find(query,String.class,"wjdc").get(0)+"}";
        return result;
    }

    public long wjdc_number(){
        return mongoTemplate.count(new Query(),"wjdc");
    }

    public String wjdc_upload(MultipartFile file, String auth) throws Exception {
        //判断上传的文件是否存在
        Query query = new Query(Criteria.where("title").is(file.getOriginalFilename().split("\\.")[0]));
        List<String> list = mongoTemplate.find(query,String.class,"wjdc");
        if (list.size()==1){
            return "存在";
        }
        //上传文件
        FtpUtils ftpUtils = new FtpUtils();
        String path_name = ftpUtils.uploadToFtp(file.getInputStream(),file.getOriginalFilename(),false);
        //获取教务通知总量
        long count = mongoTemplate.count(new Query(), "wjdc");
        count++;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("count",(double)count);
        jsonObject.put("title",file.getOriginalFilename().split("\\.")[0]);
        jsonObject.put("src","http://39.105.26.229:8080"+path_name);
        jsonObject.put("auth",auth);
//        Date date2 = new Date();
//        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
//        jsonObject.put("time",dateFormat2.format(date2));
        mongoTemplate.insert(jsonObject,"wjdc");
        return "成功";
    }

    public void wjdc_download(String name, HttpServletResponse response) throws IOException {
        Query query = new Query(Criteria.where("title").is(name));
        String data = mongoTemplate.find(query,String.class,"wjdc").get(0);
        JSONObject wjdc = JSONObject.parseObject(data);
        String filePath = wjdc.getString("src");
        String fileName =filePath.substring(filePath.lastIndexOf("/")+1) ;
        String s[] = fileName.split("\\.");
        //文件原始完整名称
        String realName = name+"."+s[1];
        // 如果文件名不为空，则进行下载
        if (fileName != null) {
            //设置文件路径
            FtpUtils ftpUtils = new FtpUtils();
            InputStream inputStream = ftpUtils.downloadFile(fileName);
            // 如果输入流存在，则进行下载
            if (inputStream!=null) {

                // 配置文件下载
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                // 下载文件能正常显示中文
                response.setHeader("Content-Disposition", "attachment;filename=" + new String(realName.getBytes("utf-8"), "ISO8859-1"));

                // 实现文件下载
                byte[] buffer = new byte[1024];
                BufferedInputStream bis = null;
                try {
                    bis = new BufferedInputStream(inputStream);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("失败!");
                }
                finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void wjdc_delete(String name) throws IOException {
        //删除文件
        Query query = new Query(Criteria.where("title").is(name));
        String delete_data = mongoTemplate.find(query,String.class,"wjdc").get(0);
        JSONObject wjdc = JSONObject.parseObject(delete_data);
        FtpUtils ftpUtils = new FtpUtils();
        String filePath = wjdc.getString("src");
        String fileName =filePath.substring(filePath.lastIndexOf("/")+1) ;
        ftpUtils.deleteFile(fileName);
        //删除mongodb中数据
        mongoTemplate.remove(query,"wjdc");
        //获取删除数据的count
        double delete_data_count =Double.parseDouble( wjdc.getString("count"));
        //获取所有数据数量
        long sum = mongoTemplate.count(new Query(),"wjdc");
        //从删除数据的下一条数据开始到最后一条数据
        if (delete_data_count!=sum){
            for (double i=delete_data_count+1;i<=sum+1;i++){
                Query query1 = new Query(Criteria.where("count").is(i));
                String data = mongoTemplate.find(query1,String.class,"wjdc").get(0);
                JSONObject jsonObject1 = JSONObject.parseObject(data);
                double count = Double.parseDouble(jsonObject1.getString("count"));
                count--;
                jsonObject1.replace("count",count);
                Update update = new Update();
                for (Map.Entry<String,Object> entry:jsonObject1.entrySet()){
                    if (!entry.getKey().equals("_id")){
                        update.set(entry.getKey(),entry.getValue());
                    }
                }
                mongoTemplate.updateMulti(query1,update,"wjdc");
            }
        }

    }
}
