package com.fanren.wx.backstage.util;


import org.apache.commons.net.ftp.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class FtpUtils {
    public static final int imageCutSize=300;
    private static final Logger log= LoggerFactory.getLogger(FtpUtils.class);

    private String userName = "fanrencli";

    private String passWord = "sDfmezMTB2FLHmSP";

    private String ip = "39.105.26.229";

    private int port = 21;

    private String CURRENT_DIR = "/";     // 文件存放的目录

    public static final String DIRSPLIT="/";

    public String getCURRENT_DIR() {
        return CURRENT_DIR;
    }


    public void setCURRENT_DIR(String cURRENTDIR) {
        CURRENT_DIR = cURRENTDIR;
    }

    // 下载的文件目录
    private String DOWNLOAD_DIR;

    // ftp客户端
    private FTPClient ftpClient = new FTPClient();

    public String getRandomName(String fileName){
        String[] s = fileName.split("\\.");
        String filename = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
        filename = filename + "." + s[1];
        return filename;
    }
    /**
     *
     * 功能：上传文件附件到文件服务器
     * @param buffIn:上传文件流
     * @param fileName：保存文件名称
     * @param needDelete：是否同时删除
     * @return
     * @throws IOException
     */
    public String uploadToFtp(InputStream buffIn, String fileName,boolean needDelete)
            throws FTPConnectionClosedException, IOException,Exception {
        fileName = getRandomName(fileName);
        boolean returnValue = false;
        // 上传文件
        try {

            // 建立连接
            connectToServer();
            // 设置传输二进制文件
            setFileType(FTP.BINARY_FILE_TYPE);
            int reply = ftpClient.getReplyCode();
            if(!FTPReply.isPositiveCompletion(reply))
            {
                ftpClient.disconnect();
                throw new IOException("failed to connect to the FTP Server:"+ip);
            }
            ftpClient.enterLocalPassiveMode();
               /* if(StringUtils.checkStr(CURRENT_DIR)){
                	if(!existDirectory(CURRENT_DIR)){
                		this.createDirectory(CURRENT_DIR);
                	}
                    ftpClient.changeWorkingDirectory(CURRENT_DIR);
                }*/
            // 上传文件到ftp
            returnValue = ftpClient.storeFile(fileName, buffIn);
            if(needDelete){
                ftpClient.deleteFile(fileName);
            }
            // 输出操作结果信息
            if (returnValue) {
                log.info("uploadToFtp INFO: upload file  to ftp : succeed!");
            } else {
                log.info("uploadToFtp INFO: upload file  to ftp : failed!");
            }
            buffIn.close();
            // 关闭连接
            closeConnect();
        } catch (FTPConnectionClosedException e) {
            log.error("ftp连接被关闭！", e);
            throw e;
        } catch (Exception e) {
            returnValue = false;
            log.error("ERR : upload file  to ftp : failed! ", e);
            throw e;
        } finally {
            try {
                if (buffIn != null) {
                    buffIn.close();
                }
            } catch (Exception e) {
                log.error("ftp关闭输入流时失败！", e);
            }
            if (ftpClient.isConnected()) {
                closeConnect();
            }
        }
        return this.CURRENT_DIR+fileName;
    }


    /**
     *
     * 功能：根据文件名称，下载文件流
     * @param filename
     * @return
     * @throws IOException
     */
    public InputStream  downloadFile(String filename)
            throws IOException {
        InputStream in=null;
        try {

            // 建立连接
            connectToServer();
            ftpClient.enterLocalPassiveMode();
            // 设置传输二进制文件
            setFileType(FTP.BINARY_FILE_TYPE);
            int reply = ftpClient.getReplyCode();
            if(!FTPReply.isPositiveCompletion(reply))
            {
                ftpClient.disconnect();
                throw new IOException("failed to connect to the FTP Server:"+ip);
            }
            ftpClient.changeWorkingDirectory(CURRENT_DIR);
            // ftp文件获取文件
            in=ftpClient.retrieveFileStream(filename);

        } catch (FTPConnectionClosedException e) {
            log.error("ftp连接被关闭！", e);
            throw e;
        } catch (Exception e) {
            log.error("ERR : upload file "+ filename+ " from ftp : failed!", e);
        }
        return in;
    }
    //删除ftp服务器上的文件
    public void  deleteFile(String filename)
            throws IOException {
        try {

            // 建立连接
            connectToServer();
            ftpClient.enterLocalPassiveMode();
            // 设置传输二进制文件
            int reply = ftpClient.getReplyCode();
            if(!FTPReply.isPositiveCompletion(reply))
            {
                ftpClient.disconnect();
                throw new IOException("failed to connect to the FTP Server:"+ip);
            }
            ftpClient.changeWorkingDirectory(CURRENT_DIR);
            // 删除文件
            ftpClient.deleteFile(filename);

        } catch (FTPConnectionClosedException e) {
            log.error("ftp连接被关闭！", e);
            throw e;
        } catch (Exception e) {
            log.error("ERR : upload file "+ filename+ " from ftp : failed!", e);
        }
    }

    /**
     * 转码[GBK -> ISO-8859-1] 不同的平台需要不同的转码
     *
     * @param obj
     * @return
     */
//    private String gbkToIso8859(Object obj) {
//        try {
//            if (obj == null)
//                return "";
//            else
//                return new String(obj.toString().getBytes("GBK"), "iso-8859-1");
//        } catch (Exception e) {
//            return "";
//        }
//    }

    /**
     * 设置传输文件的类型[文本文件或者二进制文件]
     *
     * @param fileType
     *            --BINARY_FILE_TYPE、ASCII_FILE_TYPE
     */
    private void setFileType(int fileType) {
        try {
            ftpClient.setFileType(fileType);
        } catch (Exception e) {
            log.error("ftp设置传输文件的类型时失败！", e);
        }
    }

    /**
     *
     * 功能：关闭连接
     */
    public void closeConnect() {
        try {
            if (ftpClient != null) {
                ftpClient.logout();
                ftpClient.disconnect();
            }
        } catch (Exception e) {
            log.error("ftp连接关闭失败！", e);
        }
    }

    /**
     * 连接到ftp服务器
     */
    private void connectToServer() throws FTPConnectionClosedException,Exception {
        if (!ftpClient.isConnected()) {
            int reply;
            try {
                ftpClient=new FTPClient();
                ftpClient.connect(ip,port);
                ftpClient.login(userName,passWord);
                reply = ftpClient.getReplyCode();

                if (!FTPReply.isPositiveCompletion(reply)) {
                    ftpClient.disconnect();
                    log.info("connectToServer FTP server refused connection.");
                }

            }catch(FTPConnectionClosedException ex){
                log.error("服务器:IP："+ip+"没有连接数！there are too many connected users,please try later", ex);
                throw ex;
            }catch (Exception e) {
                log.error("登录ftp服务器【"+ip+"】失败", e);
                throw e;
            }
        }
    }
    // Check the path is exist; exist return true, else false.
    public boolean existDirectory(String path) throws IOException {
        boolean flag = false;
        FTPFile[] ftpFileArr = ftpClient.listFiles(path);
        for (FTPFile ftpFile : ftpFileArr) {
            if (ftpFile.isDirectory()
                    && ftpFile.getName().equalsIgnoreCase(path)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    /**
     * 创建FTP文件夹目录
     * @param pathName
     * @return
     * @throws IOException
     */
    public boolean createDirectory(String pathName) throws IOException {
        boolean isSuccess=false;
        try{
            isSuccess=ftpClient.makeDirectory(pathName);
        }catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    /**
     * 带点的
     * @param fileName
     * @return
     */
    public static String getExtention(String fileName) {
        int pos = fileName.lastIndexOf(".");
        return fileName.substring(pos);
    }
    /**
     * 不带点
     * @param fileName
     * @return
     */
    public static String getNoPointExtention(String fileName) {
        int pos = fileName.lastIndexOf(".");
        return fileName.substring(pos+1);
    }
    /**
     *
     * 功能：根据当前时间获取文件目录
     * @return String
     */
    public static String getDateDir(Date dateParam){
        Calendar cal = Calendar.getInstance();
        if(null!=dateParam){
            cal.setTime(dateParam);
        }
        int currentYear = cal.get(Calendar.YEAR);
        int currentMouth = cal.get(Calendar.MONTH) + 1;
        int currentDay = cal.get(Calendar.DAY_OF_MONTH) ;
        //int currentHour = cal.get(Calendar.HOUR_OF_DAY);
        //return currentYear+FtpOperation.DIRSPLIT+currentMouth+FtpOperation.DIRSPLIT+currentDay+FtpOperation.DIRSPLIT+currentHour;
        return currentYear+FtpUtils.DIRSPLIT+currentMouth+FtpUtils.DIRSPLIT+currentDay;
    }

    public boolean isVideo(String filename){
        boolean flag = false;
        String reg = "(mp4|flv|avi|rm|rmvb|wmv)";
        Pattern pattern = Pattern.compile(reg);
        flag = pattern.matcher(filename).find();
        return flag;
    }

    public static boolean isResource(String filename){
        boolean flag = false;
        String reg = "(doc|docx|xls|xlsx|ppt|pptx|pdf|mp4|flv|avi|rm|rmvb|wmv)";
        Pattern pattern = Pattern.compile(reg);
        flag = pattern.matcher(filename).find();
        return flag;
    }
}
