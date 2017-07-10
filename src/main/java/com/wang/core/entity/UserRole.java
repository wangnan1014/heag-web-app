package com.wang.core.entity;

import java.util.Date;

public class UserRole {
    private Integer id;

    private Integer userid;

    private Integer roleid;

    private Integer status;

    private Integer isdelete;

    private Date createdate;

    public UserRole(Integer id, Integer userid, Integer roleid, Integer status, Integer isdelete, Date createdate) {
        this.id = id;
        this.userid = userid;
        this.roleid = roleid;
        this.status = status;
        this.isdelete = isdelete;
        this.createdate = createdate;
    }

    public UserRole() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}