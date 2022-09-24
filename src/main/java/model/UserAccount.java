package model;

public class UserAccount {
    private String userid;
    private String password;
    private int status;

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
}
