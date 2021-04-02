package com.lee.layui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lee.layui.entity.Product;
import com.lee.layui.entity.ProductCategory;
import com.lee.layui.mapper.ProductCategoryMapper;
import com.lee.layui.mapper.ProductMapper;
import com.lee.layui.service.ProductService;
import com.lee.layui.vo.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: QeeLee
 * @Date: 2021/3/26 22:16
 */
@Service("ProductService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public DataVO<ProductVO> findData(Integer page, Integer limit) {
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        // dataVO.setCount(productMapper.selectCount(null));
        IPage<Product> productIPage = new Page<>(page, limit);
        IPage<Product> result = productMapper.selectPage(productIPage, null);
        dataVO.setCount(result.getTotal());//找数

        List<Product> productList = result.getRecords();//查询记录
        List<ProductVO> productVOList = new ArrayList<>();
        for (Product product : productList) {
            ProductVO productVO = new ProductVO();
            BeanUtils.copyProperties(product, productVO);
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("id", product.getCategoryleveloneId());
            ProductCategory productCategory = productCategoryMapper.selectOne(wrapper);
            if (productCategory != null) {
                productVO.setCategorylevelone(productCategory.getName());
            }

            wrapper = new QueryWrapper();
            wrapper.eq("id", product.getCategoryleveltwoId());
            productCategory = productCategoryMapper.selectOne(wrapper);
            if (productCategory != null) {
                productVO.setCategoryleveltwo(productCategory.getName());
            }
            wrapper = new QueryWrapper();
            wrapper.eq("id", product.getCategorylevelthreeId());
            productCategory = productCategoryMapper.selectOne(wrapper);
            if (productCategory != null) {
                productVO.setCategorylevelthree(productCategory.getName());
            }
            //将搜索到的结果列表添加到vo中
            productVOList.add(productVO);

        }
        dataVO.setData(productVOList);
        return dataVO;
    }

    @Override
    public BarVO getBarVO() {
        List<ProductBarVO> list = productMapper.findallProductBarVO();
        List<String> names = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        for (ProductBarVO productBarVO : list) {
            names.add(productBarVO.getName());
            values.add(productBarVO.getCount());
        }
        BarVO barVO = new BarVO();
        barVO.setNames(names);
        barVO.setValues(values);
        return barVO;
    }



    /**
     * 制作饼图的一种方法
     * 1.在ProductBarVO里改名
     *
     *     @JsonProperty("value")
     * 2.在controller里返回productBarVO(使用mapper调用方法)
     *  @RequestMapping("/pieVO")
     *     @ResponseBody
     *     public List<ProductBarVO> getPieVO(){
     *         return productMapper.findallProductBarVO();
     *     }
     * 制作饼图的另一种方法
     * 1.写个对应的PieVO
     * @Data
     * @AllArgsConstructor
     * public class PieVO{
     *     private Integer value;
     *     private String name;
     * }
     *
     * 2.在service中添加
     * public List<PieVO> getPieVO();
     *
     * 3.在impl里写一个根据ProductBarVO创建的PieVO
     * @Override
     *     public List<PieVO> getPieVO(){
     *         List<ProductBarVO> list = productMapper.findallProductBarVO();
     *         List<PieVO> names = list.stream()
     *                 .map(e -> new PieVO(
     *                         e.getCount(),
     *                         e.getName()//得到对应的count和name赋给PieVO
     *                 )).collect(Collectors.toList());
     *         return pieVOlist;
     *         }
     *
     * 4.在controller里写一个PieVO的接口
     * @RequestMapping("/pieVO")
     *     @ResponseBody
     *     public List<PieVO> getPieVO(){
     *         return productService.getPieVO();
     *     }
     */


}
