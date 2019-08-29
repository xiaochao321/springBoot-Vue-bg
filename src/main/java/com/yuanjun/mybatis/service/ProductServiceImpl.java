package com.yuanjun.mybatis.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yuanjun.mybatis.entity.CustInfo;
import com.yuanjun.mybatis.entity.Product;
import com.yuanjun.mybatis.mapper.CustInfoMapper;
import com.yuanjun.mybatis.mapper.ProductMapper;
import com.yuanjun.mybatis.model.CustInfoQueryModel;
import com.yuanjun.mybatis.model.ProductQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl extends ServiceImpl<ProductMapper,Product>
        implements ProductService  {
    @Autowired
    private ProductMapper productMapper;


	@Override
	public Product findByName(String name) {
		return productMapper.findByName(name);
	}


	@Override
	public List<Product> findProducts(ProductQueryModel queryModel) {
		return productMapper.findProducts(queryModel);
	}
}
