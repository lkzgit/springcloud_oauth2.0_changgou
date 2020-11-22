package com.changgou.test;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.github.wxpay.sdk.WXPayUtil;
import entity.HttpClient;
import org.junit.Test;

import java.io.IOException;


public class HttpClientTest {

    /**
     * 微信支付在线开发文档
     * <https://pay.weixin.qq.com/wiki/doc/api/index.html>
     */

    /**
     * 模拟查询订单
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        //  https://api.mch.weixin.qq.com/pay/orderquery
        String url="https://api.mch.weixin.qq.com/pay/orderquery";
        HttpClient ht=new HttpClient(url);
        String xml="<xml>\n" +
                "   <appid>wx2421b1c4370ec43b</appid>\n" +
                "   <mch_id>10000100</mch_id>\n" +
                "   <nonce_str>ec2316275641faa3aacf3cc599e8730f</nonce_str>\n" +
                "   <transaction_id>1008450740201411110005820873</transaction_id>\n" +
                "   <sign>FDD167FAA73459FD921B144BAF4F4CA2</sign>\n" +
                "</xml>";
        ht.setXmlParam(xml);
        ht.setHttps(true);//是否是https请求
        ht.post();//发送post请求
        String content = ht.getContent();//获取结果
        System.out.println("发送结果测试："+content);

        DateTime parse = DateUtil.parse("2020-10-12");
        DateUtil.beginOfDay(parse);
        System.out.println(DateUtil.beginOfDay(parse));
        System.out.println("结束"+DateUtil.endOfDay(parse));
    }

    /**
     * 模拟微信同意下单
     */

    @Test
    public void test2() throws Exception {
        //https://api.mch.weixin.qq.com/pay/unifiedorder
        String url="https://api.mch.weixin.qq.com/pay/unifiedorder";
        HttpClient ht=new HttpClient(url);
        ht.setHttps(true);
        String xml="<xml>\n" +
                "   <appid>wx2421b1c4370ec43b</appid>\n" +
                "   <attach>支付测试</attach>\n" +
                "   <body>JSAPI支付测试</body>\n" +
                "   <mch_id>10000100</mch_id>\n" +
                "   <detail><![CDATA[{ \"goods_detail\":[ { \"goods_id\":\"iphone6s_16G\", \"wxpay_goods_id\":\"1001\", \"goods_name\":\"iPhone6s 16G\", \"quantity\":1, \"price\":528800, \"goods_category\":\"123456\", \"body\":\"苹果手机\" }, { \"goods_id\":\"iphone6s_32G\", \"wxpay_goods_id\":\"1002\", \"goods_name\":\"iPhone6s 32G\", \"quantity\":1, \"price\":608800, \"goods_category\":\"123789\", \"body\":\"苹果手机\" } ] }]]></detail>\n" +
                "   <nonce_str>1add1a30ac87aa2db72f57a2375d8fec</nonce_str>\n" +
                "   <notify_url>http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php</notify_url>\n" +
                "   <openid>oUpF8uMuAJO_M2pxb1Q9zNjWeS6o</openid>\n" +
                "   <out_trade_no>1415659990</out_trade_no>\n" +
                "   <spbill_create_ip>14.23.150.211</spbill_create_ip>\n" +
                "   <total_fee>1</total_fee>\n" +
                "   <trade_type>JSAPI</trade_type>\n" +
                "   <sign>0CB01533B8C1EF103065174F50BCA001</sign>\n" +
                "</xml>";

        ht.setXmlParam(xml);
        ht.post();
        String content = ht.getContent();
        WXPayUtil.xmlToMap(content);
        System.out.println("统一下单返回结果:\n"+ WXPayUtil.xmlToMap(content));
    }
}
