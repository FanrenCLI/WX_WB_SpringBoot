package com.fanren.wx.app.pojo;

public class Attend {
    private String studentId;

    private String studentName;

    private String className;

    private String time;

    public Attend(String id,String name,String className,String time){
        this.studentId=id;
        this.studentName=name;
        this.className=className;
        this.time=time;
    }
    public Attend(){

    }
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }
}