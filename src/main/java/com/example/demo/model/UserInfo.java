package com.example.demo.model;

import java.util.Objects;

public class UserInfo {

    private String userid;
    private String name;
    private String email;
    private String address;
    private String sex;
    private String create_time;
    private int status;
    private int id;
    private int age;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return status == userInfo.status && id == userInfo.id && age == userInfo.age && Objects.equals(userid, userInfo.userid) && Objects.equals(name, userInfo.name) && Objects.equals(email, userInfo.email) && Objects.equals(address, userInfo.address) && Objects.equals(sex, userInfo.sex) && Objects.equals(create_time, userInfo.create_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, name, email, address, sex, create_time, status, id, age);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userid='" + userid + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", create_time='" + create_time + '\'' +
                ", status=" + status +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
