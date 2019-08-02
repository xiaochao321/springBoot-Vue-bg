package com.yuanjun.mybatis.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yuanjun.mybatis.entity.CustInfo;
import com.yuanjun.mybatis.entity.User;
import com.yuanjun.mybatis.model.CustInfoQueryModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustInfoMapper extends BaseMapper<CustInfo>{

    @Select("select id,age,name from cust_info")
    List<CustInfo> getAll();

    CustInfo findByName(String name);

    List<CustInfo> findCustInfos(@Param("queryModel")CustInfoQueryModel queryModel);

	//Integer insert(CustInfo custInfo);


}
