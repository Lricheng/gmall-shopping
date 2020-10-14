package com.atguigu.gmall.service.manage;

import com.atguigu.gmall.bean.*;

import java.util.List;

public interface ManageService {
    /**
     * 所有1级分类
     *
     * @Author:LRC
     * @Date:11:06 下午 2020/8/17
     */
    public List<BaseCatalog1> getCatalog1();

    /**
     * 根据一级分类id查询二级分类数据
     *
     * @Author:LRC
     * @Date:11:06 下午 2020/8/17
     */
    public List<BaseCatalog2> getCatalog2(String catalog1Id);

    /**
     * 根据二级分类id查询3级分类数据
     *
     * @Author:LRC
     * @Date:11:06 下午 2020/8/17
     */
    public List<BaseCatalog3> getCatalog3(String catalog2Id);

    /**
     * 根据3级分类查询平台属性数据
     *
     * @Author:LRC
     * @Date:11:07 下午 2020/8/17
     */
    public List<BaseAttrInfo> getAttrList(String catalog3Id);


    /**
     * 保存平台属性的数据
     *
     * @Author:LRC
     * @Date:11:35 下午 2020/8/17
     */
    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    /**
     * 获取对应的平台属性值
     *
     * @Author:LRC
     * @Date:10:11 上午 2020/8/18
     */
    BaseAttrInfo getAttrInfo(String attrId);


    /**
     * 根据三级分类id返回其的spu集合
     *
     * @Author:LRC
     * @Date:10:29 下午 2020/8/18
     */
    List<SpuInfo> getSpuInfoList(SpuInfo spuInfo);

    /**
     * 列出基本销售属性
     *
     * @Author:LRC
     * @Date:11:29 下午 2020/8/18
     */
    List<BaseSaleAttr> getBaseSaleAttrList();


    /**
     * 保存spu的数据
     *
     * @Author:LRC
     * @Date:11:48 上午 2020/8/23
     */
    public void saveSpuInfo(SpuInfo spuInfo);

    /**
     * 根据对象中的spuId来列出对应的图片
     *
     * @Author:LRC
     * @Date:12:03 下午 2020/8/24
     */
    List<SpuImage> getSpuImageList(SpuImage spuImage);

    /**
     * 根据spuid获取销售属性集合
     *
     * @Author:LRC
     * @Date:12:00 下午 2020/8/27
     */
    List<SpuSaleAttr> getSpuAttrList(String spuId);

    /**
     * 保存skuInfo 数据
     *
     * @Author:LRC
     * @Date:11:45 上午 2020/8/30
     */
    void saveSkuInfo(SkuInfo skuInfo);
}
