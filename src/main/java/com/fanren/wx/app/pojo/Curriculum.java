package com.fanren.wx.app.pojo;

public class Curriculum {
    private String kcmc;

    private String kcdd;

    private String teachers;

    private String skbj;

    private String weekTime;

    private String dayTime;

    private String zhouci;

    public String getKcmc() {
        return kcmc;
    }

    public void setKcmc(String kcmc) {
        this.kcmc = kcmc == null ? null : kcmc.trim();
    }

    public String getKcdd() {
        return kcdd;
    }

    public void setKcdd(String kcdd) {
        this.kcdd = kcdd == null ? null : kcdd.trim();
    }

    public String getTeachers() {
        return teachers;
    }

    public void setTeachers(String teachers) {
        this.teachers = teachers == null ? null : teachers.trim();
    }

    public String getSkbj() {
        return skbj;
    }

    public void setSkbj(String skbj) {
        this.skbj = skbj == null ? null : skbj.trim();
    }

    public String getWeekTime() {
        return weekTime;
    }

    public void setWeekTime(String weekTime) {
        this.weekTime = weekTime == null ? null : weekTime.trim();
    }

    public String getDayTime() {
        return dayTime;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime == null ? null : dayTime.trim();
    }

    public String getZhouci() {
        return zhouci;
    }

    public void setZhouci(String zhouci) {
        this.zhouci = zhouci == null ? null : zhouci.trim();
    }
}