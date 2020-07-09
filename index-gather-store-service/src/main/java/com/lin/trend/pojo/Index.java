package com.lin.trend.pojo;

import java.io.Serializable;


//指数类，用来存取指数的代码，名字
public class Index implements Serializable{
    String code;
    String name;
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}