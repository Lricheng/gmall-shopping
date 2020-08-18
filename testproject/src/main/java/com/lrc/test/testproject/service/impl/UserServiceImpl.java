package com.lrc.test.testproject.service.impl;

import com.lrc.test.testproject.bean.UserInfo;
import com.lrc.test.testproject.mapper.UserInfoMapper;
import com.lrc.test.testproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public void addUser(UserInfo userInfo) {
        //有选择的添加
        userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public void update(UserInfo userInfo) {
        //update

        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public void updateByName(UserInfo userInfo) {
        //根据name修改loginname
        //1:第一个seruInfo表示要修改的数据来源
        //2：第二个表示要根据上面条件来修改
        //update userInfo set loginName=? where name=?


        Example example = new Example(UserInfo.class);
        //property指的是实体类的属性名还是数据库中的字段名？--->实体类的属性名
        example.createCriteria().andEqualTo("name",userInfo.getName());
        userInfoMapper.updateByExampleSelective(userInfo,example);
    }

//    @Override
//    public boolean delete(UserInfo userInfo) {
//
//
//        userInfoMapper.deleteByPrimaryKey(userInfo.getId());
//        return true;
//    }
    @Override
    public boolean delete(UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name",userInfo.getName());
        userInfoMapper.deleteByExample(example);
        return true;
    }
}
