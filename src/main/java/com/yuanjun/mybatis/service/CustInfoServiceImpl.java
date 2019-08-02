package com.yuanjun.mybatis.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yuanjun.mybatis.entity.CustInfo;
import com.yuanjun.mybatis.entity.Person;
import com.yuanjun.mybatis.mapper.CustInfoMapper;
import com.yuanjun.mybatis.mapper.PersonMapper;
import com.yuanjun.mybatis.model.CustInfoQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustInfoServiceImpl extends ServiceImpl<CustInfoMapper,CustInfo>
        implements CustInfoService  {
    @Autowired
    private CustInfoMapper custInfoMapper;


	@Override
	public CustInfo findByName(String name) {
		return custInfoMapper.findByName(name);
	}


	@Override
	public List<CustInfo> findCustInfos(CustInfoQueryModel queryModel) {
		return custInfoMapper.findCustInfos(queryModel);
	}
}
