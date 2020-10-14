package com.atguigu.gmall.manageweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.SkuInfo;
import com.atguigu.gmall.bean.SpuImage;
import com.atguigu.gmall.bean.SpuSaleAttr;
import com.atguigu.gmall.service.manage.ManageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SkuManageController {
//    @RequestMapping("spuImageList")
//    public List<SpuImage> spuImageList(String spuId){
//
//    }

    @Reference
    private ManageService manageService;


    @RequestMapping("ok")
    public String ok() {
        return "oktest";
    }

    @RequestMapping(value = "spuImageList", method = RequestMethod.GET)
    public List<SpuImage> spuImageList(SpuImage spuImage) {
        return manageService.getSpuImageList(spuImage);
    }

    @RequestMapping("spuSaleAttrList")
    public List<SpuSaleAttr> spuSaleAttrList(String spuId) {
        return manageService.getSpuAttrList(spuId);
    }

    @RequestMapping("saveSkuInfo")
    public void saveSkuInfo(@RequestBody SkuInfo skuInfo) {
        if (skuInfo != null) {
            manageService.saveSkuInfo(skuInfo);
        }
    }
}
