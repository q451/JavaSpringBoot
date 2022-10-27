package com.example.demo.model.user;

import com.example.demo.model.common.CommonIdentify;

import java.util.Objects;

public class UserRole {
    private int id;
    private String userid;
    private int role;
    private int status;

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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
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
        UserRole userRole = (UserRole) o;
        return id == userRole.id && role == userRole.role && status == userRole.status && Objects.equals(userid, userRole.userid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userid, role, status);
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", role=" + role +
                ", status=" + status +
                '}';
    }
}
