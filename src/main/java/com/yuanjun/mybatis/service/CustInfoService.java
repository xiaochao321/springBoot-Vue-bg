package com.yuanjun.mybatis.service;

import com.baomidou.mybatisplus.service.IService;
import com.yuanjun.mybatis.entity.CustInfo;
import com.yuanjun.mybatis.entity.Person;

public interface CustInfoService extends IService<CustInfo> {

	CustInfo findByName(String name);
}
