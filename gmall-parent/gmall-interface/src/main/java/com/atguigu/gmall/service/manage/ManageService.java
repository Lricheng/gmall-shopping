package com.atguigu.gmall.service.manage;

import com.atguigu.gmall.bean.*;

import java.beans.Transient;
import java.util.List;

public interface ManageService {
    /**
    *
    * 所有1级分类
    *
    * @Author:LRC
    * @Date:11:06 下午 2020/8/17
    */
    public List<BaseCatalog1> getCatalog1();

    /**
    *
    * 根据一级分类id查询二级分类数据
    *
    * @Author:LRC
    * @Date:11:06 下午 2020/8/17
    */
    public List<BaseCatalog2> getCatalog2(String catalog1Id);

    /**
    *
    * 根据二级分类id查询3级分类数据
    *
    * @Author:LRC
    * @Date:11:06 下午 2020/8/17
    */
    public List<BaseCatalog3> getCatalog3(String catalog2Id);

    /**
    *
    * 根据3级分类查询平台属性数据
    *
    * @Author:LRC
    * @Date:11:07 下午 2020/8/17
    */
    public List<BaseAttrInfo> getAttrList(String catalog3Id);



    /**
    * 
    * 保存平台属性的数据
    *
    * @Author:LRC
    * @Date:11:35 下午 2020/8/17
    */
    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    /**
    *
    * 获取对应的平台属性值
    *
    * @Author:LRC
    * @Date:10:11 上午 2020/8/18
    */
    BaseAttrInfo getAttrInfo(String attrId);
}
