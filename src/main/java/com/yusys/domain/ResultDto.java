package com.yusys.domain;

import java.util.List;

/**
 * 自定义返回体
 */
public class ResultDto<T> {

    // 数据条数
    private int count;
    // 成功或失败
    private String message;
    // 数据
    private List<T> data;
}