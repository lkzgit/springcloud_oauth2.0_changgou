package com.changgou.file.controller;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException, MyException {
        String path="C:\\Users\\luck\\Desktop\\修过.jpg";

        String filePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();

        System.out.println(filePath);
        //1.加载配置文件 配置文件中的内容就是tracker服务地址
        ClientGlobal.init(filePath);
        // 创建一个TrackerClient 对象 直接new 一个
        TrackerClient trackerClient=new TrackerClient();
        // 3.使用TrackerClient 对象创建连接，获得一个TrackerClient对象
        TrackerServer connection = trackerClient.getConnection();
        //4.创建一个StorageServer 的引用 值为null
        StorageServer storageServer=null;
        // 5.创建一个StorageServer对象 ，需要两个参数TrackerServer对象，StorageServer的引用
        StorageClient storageClient = new StorageClient(connection, storageServer);
        //6.使用 StorageClient 对象上传图片
        String[] strings = storageClient.upload_file(path, "jpg", null);
        //7.返回数组 包含组名和图片路径
        for(String ss: strings){
            System.out.println(ss);
        }
        System.out.println("上传完成");

    }
}
