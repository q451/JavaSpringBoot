package com.example.demo.model.common;

import java.util.Objects;

public class CommonRole {
    private int id;
    private String name;
    private int identify;
    private int status;

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
        CommonRole that = (CommonRole) o;
        return id == that.id && identify == that.identify && status == that.status && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, identify, status);
    }

    @Override
    public String toString() {
        return "CommonRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", identify=" + identify +
                ", status=" + status +
                '}';
    }
}
