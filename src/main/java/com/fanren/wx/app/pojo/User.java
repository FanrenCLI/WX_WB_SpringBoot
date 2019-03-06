package com.fanren.wx.app.pojo;

public class User {
    private String userId;

    private String pwd;

    private String openId;

    private String role;

    private String picture;

    private String pictureDir;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getPictureDir() {
        return pictureDir;
    }

    public void setPictureDir(String pictureDir) {
        this.pictureDir = pictureDir == null ? null : pictureDir.trim();
    }
}