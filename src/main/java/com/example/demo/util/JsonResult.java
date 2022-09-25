package com.example.demo.util;

import java.io.Serializable;

public class JsonResult<E> implements Serializable {
    private Integer status;
    private String message;
    private E data;

    public JsonResult() {
    }

    public JsonResult(Integer status) {
        this.status = status;
    }

    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResult(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
