package com.yuanjun.mybatis.service;

import com.baomidou.mybatisplus.service.IService;
import com.yuanjun.mybatis.entity.CustInfo;
import com.yuanjun.mybatis.entity.Person;
import com.yuanjun.mybatis.model.CustInfoQueryModel;

import java.util.List;

public interface CustInfoService extends IService<CustInfo> {

	CustInfo findByName(String name);

	List<CustInfo> findCustInfos(CustInfoQueryModel queryModel);
}
