package com.lee.layui.vo;

import lombok.Data;

/**
 * @Author: QeeLee
 * @Date: 2021/3/26 22:12
 */
@Data
public class ProductVO {
    private Integer id;
    private String name;
    private String description;
    private Float price;
    private String categorylevelone;
    private String categoryleveltwo;
    private String categorylevelthree;
    private String fileName;
}
