package com.atguigu.gmall.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
public class BaseAttrInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private String id;
    @Column
    private String attrName;
    @Column
    private String catalog3Id;


    //这个平台属性对应的baseAttrValue的集合
    @Transient //这个表示这个字段不是在表中使用，是业务需求
    private List<BaseAttrValue> attrValueList;
}