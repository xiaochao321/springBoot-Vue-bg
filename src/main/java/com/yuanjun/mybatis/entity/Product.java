package com.yuanjun.mybatis.entity;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 *@program: mybatis
 *@description:
 *@author: chaochao03.gao
 *@create: 2019-08-29 17:14
 */
@TableName("product")
public class Product {

	private int id;
	private String name;
	private String describe;
	private String imgurl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
}