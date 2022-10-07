package com.example.demo.model.user;

import com.example.demo.model.common.CommonIdentify;

import java.util.Objects;

public class UserIdentify {
    private int id;
    private String userid;
    private int identify;
    private int status;

    private CommonIdentify commonIdentify;

    public CommonIdentify getCommonIdentify() {
        return commonIdentify;
    }

    public void setCommonIdentify(CommonIdentify commonIdentify) {
        this.commonIdentify = commonIdentify;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getIdentify() {
        return identify;
    }

    public void setIdentify(int identify) {
        this.identify = identify;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserIdentify that = (UserIdentify) o;
        return id == that.id && identify == that.identify && status == that.status && Objects.equals(userid, that.userid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userid, identify, status);
    }

    @Override
    public String toString() {
        return "UserIdentify{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", identify=" + identify +
                ", status=" + status +
                '}';
    }
}
