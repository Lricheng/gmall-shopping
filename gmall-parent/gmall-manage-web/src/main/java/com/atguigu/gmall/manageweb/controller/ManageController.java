package com.atguigu.gmall.manageweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.*;
import com.atguigu.gmall.service.manage.ManageService;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class ManageController {

    @Reference
    private ManageService manageService;

    @RequestMapping("getCatalog1")
    public List<BaseCatalog1> getCatalog1() {
        return manageService.getCatalog1();
    }

    @RequestMapping("getCatalog2")
    public List<BaseCatalog2> getCatalog2(String catalog1Id) {
        return manageService.getCatalog2(catalog1Id);
    }

    @RequestMapping("getCatalog3")
    public List<BaseCatalog3> getCatalog3(String catalog2Id) {
        return manageService.getCatalog3(catalog2Id);
    }

    @RequestMapping("attrInfoList")
    public List<BaseAttrInfo> attrInfoList(String catalog3Id) {
        return manageService.getAttrList(catalog3Id);
    }

    /**
     * 保存属性和属性值的请求
     *
     * @Author:LRC
     * @Date:11:35 下午 2020/8/17
     */

    //将前台页面传递过来的json数据转换为对象@RequestBody
    @RequestMapping("saveAttrInfo")
    public void saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo) {
        // 调用服务层做保存方法
        manageService.saveAttrInfo(baseAttrInfo);
    }

    /**
     * 获取平台属性值
     *
     * @Author:LRC
     * @Date:10:11 上午 2020/8/18
     */
    @RequestMapping(value = "getAttrValueList", method = RequestMethod.POST)
    @ResponseBody
    public List<BaseAttrValue> getAttrValueList(String attrId) {
        BaseAttrInfo attrInfo = manageService.getAttrInfo(attrId);
        return attrInfo.getAttrValueList();
    }

    /**
     * 查询基本销售属性表
     *
     * @Author:LRC
     * @Date:11:32 下午 2020/8/18
     */
    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<BaseSaleAttr> getBaseSaleAttrList() {
        return manageService.getBaseSaleAttrList();
    }

    @RequestMapping("testFileUpload")
    @ResponseBody
    public String textFileUpload() throws IOException, Exception {
        String conf = this.getClass().getResource("/tracker.conf").getFile();
        ClientGlobal.init(conf);
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        String orginalFilename = "/Users/liuyi/Pictures/default.jpeg";
        String[] upload_file = storageClient.upload_file(orginalFilename, "jpeg", null);
        for (int i = 0; i < upload_file.length; i++) {
            String s = upload_file[i];
            System.out.println("s = " + s);
        }
        return "ok";

    }

    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody SpuInfo spuInfo) {
        manageService.saveSpuInfo(spuInfo);
        return "OK";
    }


}