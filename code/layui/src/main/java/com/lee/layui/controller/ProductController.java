package com.lee.layui.controller;

import com.lee.layui.mapper.ProductMapper;
import com.lee.layui.service.ProductService;
import com.lee.layui.vo.BarVO;
import com.lee.layui.vo.DataVO;
//import com.lee.layui.vo.PieVO;
import com.lee.layui.vo.ProductBarVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.xml.ws.soap.Addressing;
import java.util.List;

/**
 * @Author: QeeLee
 * @Date: 2021/3/27 14:05
 */

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;
    @RequestMapping("/list")
    public DataVO list(Integer page,Integer limit){
        return productService.findData(page, limit);
    }

    /**
     * 单体应用时的改动：
     * 1.在application.yml中添加thymeleaf相关设置
     * 2.将前端样式（layui）、图片等静态资源放置到resource/static/中，将相关.html文件放到templates中，更改url设置(/list)
     * 3.在controller中加如下映射，让控制器不走视图,而是通过thymeleaf解析:
     * ProductController（@RestController-@Controller）,
     * DataVO list上加@ResponseBody
     *
     * 注意table.html无法解析可能是因为cols下[[两个符号不能叠在一起，需要换行]]
     */

 /*   @GetMapping("/{url}")
    public String redict(@PathVariable("url")  String url){
        return url;
    }*/

    @RequestMapping("/barVO")
    @ResponseBody
    public BarVO getBarVO(){
        return productService.getBarVO();
    }


    @RequestMapping("/pieVO")
    @ResponseBody
    public List<ProductBarVO> getPieVO(){
        return productMapper.findallProductBarVO();
    }
}
