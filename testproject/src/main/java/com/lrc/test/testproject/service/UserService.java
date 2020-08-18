package com.lrc.test.testproject.service;

import com.lrc.test.testproject.bean.UserInfo;

import java.util.List;

//业务逻辑层
public interface UserService {
    /**
    *
    * 查询所有数据
    *
    * @Author:LRC
    * @Date:5:53 下午 2020/8/14
    */
    List<UserInfo> findAll();


    /**
    *
    * 添加user
    *
    * @Author:LRC
    * @Date:8:36 下午 2020/8/14
    */
    void addUser(UserInfo userInfo);

    /**
    *
    * 修改数据
    *
    * @Author:LRC
    * @Date:9:22 下午 2020/8/14
    */
    void update(UserInfo userInfo);
    /**
     *
     * 根据name修改loginname
     *
     * @Author:LRC
     * @Date:9:22 下午 2020/8/14
     */
    void updateByName(UserInfo userInfo);


    /**
    *
    * 删除
    *返回值：1：布尔 2:int 3,void
    * @Author:LRC
    * @Date:9:50 下午 2020/8/14
    */
    boolean delete(UserInfo userInfo);
}
