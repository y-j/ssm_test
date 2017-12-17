package com.digiwin.pojo;

import java.io.Serializable;
import java.util.Date;

public class Linkman implements Serializable {
    private Long id;

    private String userid;

    private String name;

    private String mobilephonenumber;

    private String email;

    private String localphonenumber;

    private String department;

    private String position;

    private String address;

    private Date createtime;

    private Date updatetime;

    @Override
    public String toString() {
        return "Linkman{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", name='" + name + '\'' +
                ", mobilephonenumber='" + mobilephonenumber + '\'' +
                ", email='" + email + '\'' +
                ", localphonenumber='" + localphonenumber + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", address='" + address + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMobilephonenumber() {
        return mobilephonenumber;
    }

    public void setMobilephonenumber(String mobilephonenumber) {
        this.mobilephonenumber = mobilephonenumber == null ? null : mobilephonenumber.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getLocalphonenumber() {
        return localphonenumber;
    }

    public void setLocalphonenumber(String localphonenumber) {
        this.localphonenumber = localphonenumber == null ? null : localphonenumber.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}