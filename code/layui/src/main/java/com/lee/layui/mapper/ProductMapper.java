package com.lee.layui.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.layui.entity.Product;
import com.lee.layui.vo.ProductBarVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: QeeLee
 * @Date: 2021/3/26 21:18
 */

public interface ProductMapper extends BaseMapper<Product> {

    @Select("select p.name,sum(quantity) count from p_order od,product_category p where od.product_id=p.id group by product_id;")
    public List<ProductBarVO> findallProductBarVO();
}
