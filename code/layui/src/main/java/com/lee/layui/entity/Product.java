package com.lee.layui.entity;

import lombok.Data;

/**
 * @Author: QeeLee
 * @Date: 2021/3/26 21:15
 */
@Data
public class Product {
    private Integer id;
    private String name;
    private String description;
    private Float price;
    private Integer categoryleveloneId;
    private Integer categoryleveltwoId;
    private Integer categorylevelthreeId;
    private String fileName;
}
