package com.yuanjun.mybatis.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.yuanjun.mybatis.entity.CustInfo;
import com.yuanjun.mybatis.entity.User;
import com.yuanjun.mybatis.service.CustInfoService;
import com.yuanjun.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("custInfo")
public class CustInfoController {

    @Autowired
    private CustInfoService custInfoService;

    @ResponseBody
    @RequestMapping("/save")
    public ModelAndView home() {
        System.out.println("beelt测试");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("email", "apk2sf@163.com");
        modelAndView.setViewName("add");
        return modelAndView;
    }

    @RequestMapping("findByName")
    public CustInfo findByName(){
        return custInfoService.findByName("yuanjun");
    }

    /**
     * 条件的拼接构造器
     * 1.new EntityWrapper()
     * 2.关键词的使用：where,andNew,order,
     * 分页查询操作
     * @return
     */
    @RequestMapping("test1")
    public Page<CustInfo> findByPage(){
        return custInfoService.selectPage(new Page<CustInfo>(1,2),new EntityWrapper<CustInfo>()
                .where("name={0}","yuanjun")
                .andNew("age>{0}",10)
                .orderBy("age"));
    }

    /**
     * 保存操作
     * @return
     */
    @RequestMapping("saveCust")
    public String saveUser(@RequestBody CustInfo custInfo){
        //CustInfo custInfo = new CustInfo();
        //custInfo.setName("小超");
        //custInfo.setMobile(13570006694L);
		custInfoService.insert(custInfo);
        return "保存成功";
    }

    /**
     * 更新操作
     * @param id
     * @return
     */
    @RequestMapping("updateUser")
    public String updateUser(int id){
        CustInfo user = custInfoService.selectById(id);
        user.setMobile(1234444l);
		custInfoService.updateById(user);
        return "更新成功";
    }

    /***
     * 删除操作
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public String deleteUser(int id){
		custInfoService.deleteById(id);
        return "删除成功";
    }
}
