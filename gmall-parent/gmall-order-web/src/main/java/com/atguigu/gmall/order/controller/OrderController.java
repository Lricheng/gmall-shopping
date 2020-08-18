package com.atguigu.gmall.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
@Controller
public class OrderController {

    @Reference
    UserService userService;

    @RequestMapping("findAllUser")
    @ResponseBody //第一个作用是返回json。fastjson.jar 2：直接将数据现实到页面
    public List<UserInfo> findAllUser() {
        //返回一个视图名称叫做index.html

        return userService.findAll();
    }

    @RequestMapping("initOrder")
    @ResponseBody //第一个作用是返回json。fastjson.jar 2：直接将数据现实到页面
    public List<UserAddress> initOrder(String userId) {
        return userService.getUserAddressList(userId);
    }
}
