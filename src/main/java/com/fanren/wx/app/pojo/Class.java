package com.fanren.wx.app.pojo;

public class Class {
    private String classId;

    private String name;

    private String majorId;

    private String studentNumber;

    private String headmasterId;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId == null ? null : majorId.trim();
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber == null ? null : studentNumber.trim();
    }

    public String getHeadmasterId() {
        return headmasterId;
    }

    public void setHeadmasterId(String headmasterId) {
        this.headmasterId = headmasterId == null ? null : headmasterId.trim();
    }
}