package com.lee.layui.service;

import com.lee.layui.vo.BarVO;
import com.lee.layui.vo.DataVO;
//import com.lee.layui.vo.PieVO;
import com.lee.layui.vo.ProductVO;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.List;

/**
 * @Author: QeeLee
 * @Date: 2021/3/26 22:12
 */

public interface ProductService {
    public DataVO<ProductVO> findData(Integer page,Integer limit);
    public BarVO getBarVO();

}
