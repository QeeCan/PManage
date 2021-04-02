package com.lee.layui.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author: QeeLee
 * @Date: 2021/3/27 20:53
 */
@Data
public class ProductBarVO {
    private String name;
    //json改名器
    @JsonProperty("value")
    private Integer count;
}
