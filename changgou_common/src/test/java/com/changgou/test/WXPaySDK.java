package com.changgou.test;

import com.github.wxpay.sdk.WXPayUtil;
import entity.HttpClient;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WXPaySDK {

    /**
     * 测试随机生成字符串
     */
    @Test
    public void test1(){
        //生成随机的字符串
        String s = WXPayUtil.generateNonceStr();
        System.out.println("随机字符串:"+s);
    }

    /**
     * 测试Map转化XML字符串
     */
    @Test
    public void test2() throws Exception {
        Map<String,String> map=new HashMap<>();
        map.put("name","zhangsan");
        map.put("age","1");

        String s = WXPayUtil.mapToXml(map);
        System.out.println("Map转化xml:"+s);
    }

    /**
     * 测试xml转化map
     */
    @Test
    public void test3() throws Exception {
        String s="<xml>\n" +
                "<name>zhangsan</name>\n" +
                "<age>1</age>\n" +
                "</xml>";

        Map<String, String> map = WXPayUtil.xmlToMap(s);
        System.out.println("xml转化map:"+map);
    }


    /**
     * 测试httpClient
     */
    @Test
    public void test4(){

    }
}
