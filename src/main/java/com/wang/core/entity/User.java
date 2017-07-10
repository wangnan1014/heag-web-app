package com.wang.core.entity;

import java.util.Date;

public class User {
    private Integer id;

    private String username;

    private String password;

    private String phone;

    private Integer userid;

    private Integer status;

    private Date createdate;

    private String email;

    public User(Integer id, String username, String password, String phone, Integer userid, Integer status, Date createdate, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.userid = userid;
        this.status = status;
        this.createdate = createdate;
        this.email = email;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}