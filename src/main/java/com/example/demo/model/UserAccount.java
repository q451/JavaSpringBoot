package com.example.demo.model;

import java.util.Objects;

public class UserAccount {
    private String userid;
    private int id;
    private String password;
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

    public String getPassword() {
        return password;
    }

    public int getStatus() {
        return status;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserAccount that = (UserAccount) o;
//        return id == that.id && status == that.status && Objects.equals(userid, that.userid) && Objects.equals(password, that.password);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(userid, id, password, status);
//    }

//    @Override
//    public String toString() {
//        return "UserAccount{" +
//                "userid='" + userid + '\'' +
//                ", id=" + id +
//                ", password='" + password + '\'' +
//                ", status=" + status +
//                '}';
//    }
}
