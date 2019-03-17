package com.fanren.wx.app.pojo;

public class Statistics {
    private String studentId;

    private String name;

    private String cyd;

    private String zxsc;

    private String lxt;

    private String sum;

    private String mean;

    private String rank;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCyd() {
        return cyd;
    }

    public void setCyd(String cyd) {
        this.cyd = cyd == null ? null : cyd.trim();
    }

    public String getZxsc() {
        return zxsc;
    }

    public void setZxsc(String zxsc) {
        this.zxsc = zxsc == null ? null : zxsc.trim();
    }

    public String getLxt() {
        return lxt;
    }

    public void setLxt(String lxt) {
        this.lxt = lxt == null ? null : lxt.trim();
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum == null ? null : sum.trim();
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean == null ? null : mean.trim();
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank == null ? null : rank.trim();
    }
}