package com.yuanjun.mybatis.service;

import com.baomidou.mybatisplus.service.IService;
import com.yuanjun.mybatis.entity.CustInfo;
import com.yuanjun.mybatis.entity.Product;
import com.yuanjun.mybatis.model.CustInfoQueryModel;
import com.yuanjun.mybatis.model.ProductQueryModel;

import java.util.List;

public interface ProductService extends IService<Product> {

	Product findByName(String name);

	List<Product> findProducts(ProductQueryModel queryModel);
}
