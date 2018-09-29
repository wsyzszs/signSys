package com.qfedu.sign.pojo;

import java.util.Date;

public class SignLog {
    private Integer id;

    private Integer uid;

    private Date signin;

    private Date signout;

    private String stat = "";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getSignin() {
        return signin;
    }

    public void setSignin(Date signin) {
        this.signin = signin;
    }

    public Date getSignout() {
        return signout;
    }

    public void setSignout(Date signout) {
        this.signout = signout;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}