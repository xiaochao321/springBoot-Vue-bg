package com.yuanjun.mybatis.aspect;

import com.yuanjun.mybatis.annotation.CurDataSource;
import com.yuanjun.mybatis.configuration.DataSourceNames;
import com.yuanjun.mybatis.source.DynamicDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.lang.reflect.Method;

/**
 *@program: mybatis
 *@description: 多数据源切面处理类
 *@author: chaochao03.gao
 *@create: 2019-11-14 11:24
 */
@Aspect
@Component
public class DataSourceAspect implements Ordered {


	@Pointcut("@annotation(com.yuanjun.mybatis.annotation.CurDataSource)")
	public void dataSourcePointCut(){
	}

	@Around("dataSourcePointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		MethodSignature signature = (MethodSignature) point.getSignature();
		Method method = signature.getMethod();

		CurDataSource ds = method.getAnnotation(CurDataSource.class);
		if(ds == null){
			DynamicDataSource.setDataSource(DataSourceNames.FIRST);
		}else{
			DynamicDataSource.setDataSource(ds.name());
		}

		try {
			return point.proceed();
		} finally {
			DynamicDataSource.clearDataSource();

		}

	}
	@Override
	public int getOrder() {
		return 1;
	}
}