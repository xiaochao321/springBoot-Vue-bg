package com.yuanjun.mybatis.source;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 *@program: mybatis
 *@description:扩展 Spring 的 AbstractRoutingDataSource 抽象类，重写 determineCurrentLookupKey 方法
 * 动态数据源
 *@author: chaochao03.gao
 *@create: 2019-11-14 11:09
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
	private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

	public DynamicDataSource(DataSource defaultTargetDataSource,Map<Object, Object> targetDataSources){
		super.setDefaultTargetDataSource(defaultTargetDataSource);
		super.setTargetDataSources(targetDataSources);
		super.afterPropertiesSet();
	}
	@Override
	protected Object determineCurrentLookupKey() {
		return getDataSource();
	}
	public static void setDataSource(String dataSource) {
		CONTEXT_HOLDER.set(dataSource);
	}

	public static String getDataSource(){
		return CONTEXT_HOLDER.get();
	}
	public static void clearDataSource() {
		CONTEXT_HOLDER.remove();
	}
}