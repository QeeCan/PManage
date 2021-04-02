package com.lee.layui.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: QeeLee
 * @Date: 2021/3/26 21:56
 */
@Data
public class DataVO<T> {
    private Integer code;
    private String msg;
    private Long count;
    private List<T> data;
}
