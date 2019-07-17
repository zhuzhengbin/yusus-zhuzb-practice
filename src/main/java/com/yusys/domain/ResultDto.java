package com.yusys.domain;

import org.springframework.context.annotation.Bean;

/**
 * 响应体
 */

public class ResultDto {

    // 默认200响应码
    private int code = 200;
    private String message = "success";


    public ResultDto() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
