package com.wang.core.entity;

public class RoleResource {
    private Integer id;

    private Integer resourceid;

    private String resourcename;

    private Integer pid;

    private Integer opentype;

    private String img;

    private String url;

    private Integer status;

    private Integer roleid;

    private String bgcolor;

    public RoleResource(Integer id, Integer resourceid, String resourcename, Integer pid, Integer opentype, String img, String url, Integer status, Integer roleid, String bgcolor) {
        this.id = id;
        this.resourceid = resourceid;
        this.resourcename = resourcename;
        this.pid = pid;
        this.opentype = opentype;
        this.img = img;
        this.url = url;
        this.status = status;
        this.roleid = roleid;
        this.bgcolor = bgcolor;
    }

    public RoleResource() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResourceid() {
        return resourceid;
    }

    public void setResourceid(Integer resourceid) {
        this.resourceid = resourceid;
    }

    public String getResourcename() {
        return resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename = resourcename == null ? null : resourcename.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getOpentype() {
        return opentype;
    }

    public void setOpentype(Integer opentype) {
        this.opentype = opentype;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getBgcolor() {
        return bgcolor;
    }

    public void setBgcolor(String bgcolor) {
        this.bgcolor = bgcolor == null ? null : bgcolor.trim();
    }
}