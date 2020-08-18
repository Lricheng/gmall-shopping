package com.lrc.test.testproject.controller;

import com.lrc.test.testproject.bean.UserInfo;
import com.lrc.test.testproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("findAll")
    @ResponseBody
    public List<UserInfo> findAll(){
        return userService.findAll();
    }


    @RequestMapping("addUser")
    @ResponseBody
    public  String addUser(UserInfo userInfo){
        userInfo.setLoginName("test");
        userInfo.setPasswd("6666");
        userService.addUser(userInfo);
        //获取添加之后的主键
        return userInfo.getId();
    }

    @RequestMapping("updateById")
    @ResponseBody
    public  String updateUser(UserInfo userInfo){
        userInfo.setId("6");
        userInfo.setName("update");
        userService.update(userInfo);
        return "OK";
    }
    @RequestMapping("updateByName")
    @ResponseBody
    public  String updateUserByName(UserInfo userInfo){
        userInfo.setName("update");
        userInfo.setLoginName("uodateLoginNameByName");
        userService.updateByName(userInfo);
        return "OK";
    }
    @RequestMapping("delete")
    @ResponseBody
    public  String deleteById(UserInfo userInfo){
        System.out.println(userInfo);

//        userInfo.setId(id);
        if (userService.delete(userInfo)){
            return "true";
        }
        return "false";
    }
}
