package com.fanren.wx.backstage.service;

import com.alibaba.fastjson.JSONObject;
import com.fanren.wx.app.dao.ResourceMapper;
import com.fanren.wx.app.pojo.Resource;
import com.fanren.wx.app.pojo.ResourceExample;
import com.fanren.wx.backstage.util.FileUtil;
import com.fanren.wx.backstage.util.FtpUtils;
import com.fanren.wx.backstage.util.UpdateSelective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ResourceService_H {
    @Autowired
    ResourceMapper resourceMapper;
    @Autowired
    MongoTemplate mongoTemplate;

    public List<Resource> resource_list() {
        ResourceExample resourceExample = new ResourceExample();
        return resourceMapper.selectByExample(resourceExample);
    }

    public void resource_upload(MultipartFile file, Resource resource) {
        List<String> liststr = FileUtil.fileupload(file);
        String strs[] = file.getOriginalFilename().split("\\.");
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        resource.setResourceDir(liststr.get(0).substring(1) + liststr.get(1));
        resource.setResourceName(strs[0]);
        resource.setUploadTime(dateFormat.format(date));
        resource.setDownloadNumber("0");
        resourceMapper.insertSelective(resource);
    }

    public long resource_number() {
        ResourceExample resourceExample = new ResourceExample();
        return resourceMapper.countByExample(resourceExample);
    }

    public Resource GetResource(String name) {
        ResourceExample resourceExample = new ResourceExample();
        ResourceExample.Criteria criteria = resourceExample.createCriteria();
        criteria.andResourceNameEqualTo(name);
        return resourceMapper.selectByExample(resourceExample).get(0);
    }

    public void resource_delete(String name) {
        Resource resource = GetResource(name);
        File file = new File(resource.getResourceDir());
        file.delete();
        ResourceExample resourceExample = new ResourceExample();
        ResourceExample.Criteria criteria = resourceExample.createCriteria();
        criteria.andResourceNameEqualTo(name);
        resourceMapper.deleteByExample(resourceExample);
    }

    public void resource_download(String name, HttpServletResponse response) throws UnsupportedEncodingException {
        Resource resource = GetResource(name);
        String filePath = resource.getResourceDir();
        String fileName =filePath.substring(filePath.lastIndexOf("/")+1) ;
        String s[] = fileName.split("\\.");
        //文件原始完整名称
        String realName = resource.getResourceName()+"."+s[1];
        // 如果文件名不为空，则进行下载
        if (fileName != null) {
            //设置文件路径
            File file = new File(filePath);
            // 如果文件名存在，则进行下载
            if (file.exists()) {

                // 配置文件下载
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                // 下载文件能正常显示中文
                response.setHeader("Content-Disposition", "attachment;filename=" + new String(realName.getBytes("utf-8"), "ISO8859-1"));

                // 实现文件下载
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("成功!");
                    //增加下载量
                    int download_number = Integer.parseInt(resource.getDownloadNumber());
                    download_number++;
                    //设置下载量
                    resource.setDownloadNumber(String.valueOf(download_number));
                    //更新下载量
                    ResourceExample resourceExample = new ResourceExample();
                    ResourceExample.Criteria criteria = resourceExample.createCriteria();
                    criteria.andResourceNameEqualTo(resource.getResourceName());
                    Resource r = (Resource) UpdateSelective.selectiveFun(resource);
                    resourceMapper.updateByExampleSelective(r,resourceExample);
                }
                catch (Exception e) {
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
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public String resource_upload_ftp(MultipartFile file, Resource resource) throws Exception {
        //判断文件是否重复,重复则不上传
        ResourceExample resourceExample = new ResourceExample();
        ResourceExample.Criteria criteria = resourceExample.createCriteria();
        criteria.andResourceNameEqualTo(file.getOriginalFilename().split("\\.")[0]);
        if(resourceMapper.selectByExample(resourceExample).size()==1){
            return "存在";
        }else if(FtpUtils.isResource(file.getOriginalFilename())==false){
            return "格式错误";
        }else {
            //创建ftp文件
            FtpUtils ftpUtils = new FtpUtils();
            //上传ftp文件
            String path_name = ftpUtils.uploadToFtp(file.getInputStream(),file.getOriginalFilename(),false);
            //获取并设置源文件名称
            String strs[] = file.getOriginalFilename().split("\\.");
            resource.setResourceName(strs[0]);
            //设置文件上传的时间
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            resource.setUploadTime(dateFormat.format(date));
            //设置文件上传的地址
            resource.setResourceDir("http://39.105.26.229:8080"+path_name);
            //设置文件的初始下载量为0
            resource.setDownloadNumber("0");
            //若为视频文件则添加信息到mongodb数据库
            if(ftpUtils.isVideo(file.getOriginalFilename())){
                Query query = new Query();
                long count = mongoTemplate.count(query, "video");
                count++;
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("count",(double)count);
                jsonObject.put("title",strs[0]);
                jsonObject.put("src","http://39.105.26.229:8080"+path_name);
                jsonObject.put("auth",resource.getUploaderName());
                Date date2 = new Date();
                SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
                jsonObject.put("time",dateFormat2.format(date2));
                //String data = "{\"count\":"+(double)count+",\"title\":"+"\""+strs[0]+"\""+",\"src\":\"http://39.105.26.229:8080"+path_name+"\""+",\"auth\":"+"\""+resource.getUploaderName()+"\""+",\"time\":"+"\""+dateFormat2.format(date2)+"\"}";
                //System.out.println(data);
                mongoTemplate.insert(jsonObject,"video");
            }
            resourceMapper.insertSelective(resource);
            return "成功";
        }
    }

    public void resource_download_ftp(String name, HttpServletResponse response) throws IOException {
        Resource resource = GetResource(name);
        String filePath = resource.getResourceDir();
        String fileName =filePath.substring(filePath.lastIndexOf("/")+1) ;
        String s[] = fileName.split("\\.");
        //文件原始完整名称
        String realName = resource.getResourceName()+"."+s[1];
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
                    System.out.println("成功!");
                    //增加下载量
                    int download_number = Integer.parseInt(resource.getDownloadNumber());
                    download_number++;
                    //设置下载量
                    resource.setDownloadNumber(String.valueOf(download_number));
                    System.out.println(download_number);
                    //更新下载量
                    ResourceExample resourceExample = new ResourceExample();
                    ResourceExample.Criteria criteria = resourceExample.createCriteria();
                    criteria.andResourceIdEqualTo(resource.getResourceId());
                    resourceMapper.updateByExampleSelective(resource,resourceExample);
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

    public void resource_delete_ftp(String name) throws IOException {
        //删除文件
        Resource resource = GetResource(name);
        FtpUtils ftpUtils = new FtpUtils();
        String filePath = resource.getResourceDir();
        String fileName =filePath.substring(filePath.lastIndexOf("/")+1) ;
        ftpUtils.deleteFile(fileName);
        //清除mysql中的记录
        ResourceExample resourceExample = new ResourceExample();
        ResourceExample.Criteria criteria = resourceExample.createCriteria();
        criteria.andResourceNameEqualTo(name);
        resourceMapper.deleteByExample(resourceExample);
        //若文件为视频格式，则清除mongodb中的数据
        if(ftpUtils.isVideo(fileName)){
            //从mongodb获取视频文件数据
            Query query = new Query(Criteria.where("title").is(name));
            String delete_data =  mongoTemplate.find(query,String.class,"video").get(0);
            //删除此条数据
            mongoTemplate.remove(query,"video");
            //将删除数据封装成JSON对象
            JSONObject jsonObject = JSONObject.parseObject(delete_data);
            //获取删除数据的count
            double delete_data_count =Double.parseDouble( jsonObject.getString("count"));
            //获取所有数据数量
            long sum = mongoTemplate.count(new Query(),"video");
            //从删除数据的下一条数据开始到最后一条数据
            if (delete_data_count!=sum){
                for (double i=delete_data_count+1;i<=sum+1;i++){
                    Query query1 = new Query(Criteria.where("count").is(i));
                    String data = mongoTemplate.find(query1,String.class,"video").get(0);
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
                    mongoTemplate.updateMulti(query1,update,"video");
                }
            }

        }
    }
}
