package com.atguigu.gmall.manageweb.controller;

import org.apache.commons.lang3.StringUtils;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
public class FileUploadController {
    //@Value使用的前提条件就是需要当前的累必须在spring容器中
    @Value("${fileServer.url}")
    private String fileUrl;


    @RequestMapping(value = "fileUpload", method = RequestMethod.POST)
    public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException, MyException {
        String imgUrl = fileUrl;
        if (file != null) {
            //当文件不为空的时候进行文件上传
            System.out.println("multipartFile = " + file.getName() + "|" + file.getSize());
            String conf = this.getClass().getResource("/tracker.conf").getFile();
            ClientGlobal.init(conf);
            //获取链接
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getTrackerServer();
            StorageClient storageClient = new StorageClient(trackerServer, null);
            //获取上传文件的名称
            String orginalFilename = file.getOriginalFilename();
            //获取文件的后缀名
            String extName = StringUtils.substringAfterLast(orginalFilename, ".");
            //上传文件 String[] upload_file = storageClient.upload_file(orginalFilename, extName, null); 这个方法获取的是本地文件
//            String[] upload_file = storageClient.upload_file(orginalFilename, extName, null);
            String[] upload_file = storageClient.upload_file(file.getBytes(), extName, null);
            imgUrl = fileUrl;
            for (int i = 0; i < upload_file.length; i++) {
                String path = upload_file[i];
                imgUrl += "/" + path;
            }
        }
        System.err.println(imgUrl);
        return imgUrl;
    }
}
