package com.example.demo.model.mybatisPlus;

import com.example.demo.model.user.UserAccount;
import java.util.Objects;

public class UserAccountTest {
    private int id;
    private String password;
    private String userid;
    private String email;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        UserAccountTest that = (UserAccountTest) o;
        return id == that.id && status == that.status && Objects.equals(password, that.password) && Objects.equals(userid, that.userid) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, userid, email, status);
    }

    @Override
    public String toString() {
        return "UserAccountTest{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", userid='" + userid + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }
}
