package com.yuanjun.mybatis.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yuanjun.mybatis.entity.CustInfo;
import com.yuanjun.mybatis.entity.Product;
import com.yuanjun.mybatis.model.CustInfoQueryModel;
import com.yuanjun.mybatis.model.ProductQueryModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper extends BaseMapper<Product>{

    @Select("select id,age,name from cust_info")
    List<Product> getAll();

	Product findByName(String name);

    List<Product> findProducts(@Param("queryModel") ProductQueryModel queryModel);

	//Integer insert(CustInfo custInfo);


}
