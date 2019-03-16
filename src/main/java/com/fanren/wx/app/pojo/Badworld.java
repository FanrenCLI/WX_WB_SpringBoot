package com.fanren.wx.app.pojo;

public class Badworld {
    private String badworld;

    public String getBadworld() {
        return badworld;
    }

    public void setBadworld(String badworld) {
        this.badworld = badworld == null ? null : badworld.trim();
    }
}