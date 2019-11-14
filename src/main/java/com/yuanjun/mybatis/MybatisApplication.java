package com.yuanjun.mybatis;

import com.yuanjun.mybatis.config.DynamicDataSourceConfig;
import com.yuanjun.mybatis.source.DynamicDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.yuanjun.mybatis.mapper")
@Import({DynamicDataSourceConfig.class})
public class MybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisApplication.class, args);
	}
}
