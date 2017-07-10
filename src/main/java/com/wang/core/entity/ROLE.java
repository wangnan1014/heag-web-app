package com.wang.core.entity;

import java.util.Date;

public class ROLE {
    private Integer id;

    private Integer roleid;

    private String rolename;

    private String rolenamedescription;

    private Integer status;

    private Date createdate;

    public ROLE(Integer id, Integer roleid, String rolename, String rolenamedescription, Integer status, Date createdate) {
        this.id = id;
        this.roleid = roleid;
        this.rolename = rolename;
        this.rolenamedescription = rolenamedescription;
        this.status = status;
        this.createdate = createdate;
    }

    public ROLE() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getRolenamedescription() {
        return rolenamedescription;
    }

    public void setRolenamedescription(String rolenamedescription) {
        this.rolenamedescription = rolenamedescription == null ? null : rolenamedescription.trim();
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
}