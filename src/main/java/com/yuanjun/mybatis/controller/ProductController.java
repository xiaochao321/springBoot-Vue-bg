package com.yuanjun.mybatis.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.yuanjun.mybatis.entity.CustInfo;
import com.yuanjun.mybatis.entity.Product;
import com.yuanjun.mybatis.entity.RestResult;
import com.yuanjun.mybatis.model.CustInfoQueryModel;
import com.yuanjun.mybatis.model.ProductQueryModel;
import com.yuanjun.mybatis.service.CustInfoService;
import com.yuanjun.mybatis.service.ProductService;
import com.yuanjun.mybatis.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;
	@Autowired
	private ResultGenerator resultGenerator;


    @RequestMapping("findByName")
    public Product findByName(){
        return productService.findByName("yuanjun");
    }

	@RequestMapping(value = "/getProducts" ,method= RequestMethod.POST)
	public RestResult getProducts(@RequestBody ProductQueryModel queryModel){
		System.out.println(queryModel.getName());
		List<Product> products = productService.findProducts(queryModel);
		System.out.println(products);
    	return resultGenerator.getSuccessResult("成功获取product列表",products);
	}

    /**
     * 条件的拼接构造器
     * 1.new EntityWrapper()
     * 2.关键词的使用：where,andNew,order,
     * 分页查询操作
     * @return
     */
    @RequestMapping("test1")
    public Page<Product> findByPage(){
        return productService.selectPage(new Page<Product>(1,2),new EntityWrapper<Product>()
                .where("name={0}","yuanjun")
                .andNew("age>{0}",10)
                .orderBy("age"));
    }

    /**
     * 保存操作
     * @return
     */
	@RequestMapping(value = "/saveCust" ,method= RequestMethod.POST)
    public RestResult saveUser(@RequestBody Product product){
		productService.insert(product);
		return  resultGenerator.getSuccessResult("保存成功",product);
    }

    /**
     * 更新操作
     * @param id
     * @return
     */
    @RequestMapping("updateProduct")
    public String updateUser(int id){
		Product product = productService.selectById(id);
		productService.updateById(product);
        return "更新成功";
    }

    /***
     * 删除操作
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public String deleteUser(int id){
		productService.deleteById(id);
        return "删除成功";
    }
}
