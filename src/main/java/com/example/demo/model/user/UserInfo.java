package com.example.demo.model.user;

import java.util.List;
import java.util.Objects;

public class UserInfo {
    private int id;
    private String name;
    private String userid;
    private String email;
    private int age;
    private String sex;
    private String address;
    private String create_time;
    private int status;

    private List<UserIdentify> userIdentify;
    private List<UserRole> userRole;

    public List<UserIdentify> getUserIdentify() {
        return userIdentify;
    }

    public void setUserIdentify(List<UserIdentify> userIdentify) {
        this.userIdentify = userIdentify;
    }

    public List<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(List<UserRole> userRole) {
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
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
        UserInfo userInfo = (UserInfo) o;
        return id == userInfo.id && age == userInfo.age && status == userInfo.status && Objects.equals(name, userInfo.name) && Objects.equals(userid, userInfo.userid) && Objects.equals(email, userInfo.email) && Objects.equals(sex, userInfo.sex) && Objects.equals(address, userInfo.address) && Objects.equals(create_time, userInfo.create_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, userid, email, age, sex, address, create_time, status);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userid='" + userid + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", create_time='" + create_time + '\'' +
                ", status=" + status +
                '}';
    }
}
