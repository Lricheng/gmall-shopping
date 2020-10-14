package com.atguigu.gmall.manageservice.mapper;

import com.atguigu.gmall.bean.SpuSaleAttr;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SpuSaleAttrMapper extends Mapper<SpuSaleAttr> {

    /**
     * 根据spu_id去查询销售属性集合
     * 需要使用SpuSaleAttrMapper.xml,写在Resources目录下
     *
     * @Author:LRC
     * @Date:12:12 下午 2020/8/27
     */
    List<SpuSaleAttr> selectSpuSaleAttrList(String spuId);
}