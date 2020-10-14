package com.atguigu.gmall.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
public class SkuInfo implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    String id;


    @Column
    String spuId;


    @Column
    String price;


    @Column
    String skuName;

    @Column
    String weight;

    @Column
    String skuDesc;

    @Column
    String catalog3Id;

    @Column
    String skuDefaultImg;

    @Transient
    List<SkuImage> skuImageList;

    @Transient
    List<SkuAttrValue> skuAttrValueList;

    @Transient
    List<SkuSaleAttrValue> skuSaleAttrValueList;


}
