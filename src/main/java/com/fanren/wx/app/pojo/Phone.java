package com.fanren.wx.app.pojo;

public class Phone {
    private String department;

    private String place;

    private String detailplace;

    private String phone;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getDetailplace() {
        return detailplace;
    }

    public void setDetailplace(String detailplace) {
        this.detailplace = detailplace == null ? null : detailplace.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}