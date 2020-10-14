package com.atguigu.gmall.manageservice.mapper;

import com.atguigu.gmall.bean.BaseAttrInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BaseAttrInfoMapper extends Mapper<BaseAttrInfo> {
    /**
     * 根据三级分类id查询平台属性集合
     *
     * @Author:LRC
     * @Date:10:44 上午 2020/8/30
     */
    List<BaseAttrInfo> getBaseAttrInfoListByCatalog3Id(String catalog3_id);
}