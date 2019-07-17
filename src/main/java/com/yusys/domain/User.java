package com.yusys.domain;

import java.io.File;
import java.io.Serializable;
import java.util.Arrays;

/**
 * 用户实体类
 */
public class User implements Serializable {

    private String id;
    private String name;
    private byte[] photo;
    private String userInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", photo=【我是照片】" +
                ", userInfo='" + userInfo + '\'' +
                '}';
    }
}
