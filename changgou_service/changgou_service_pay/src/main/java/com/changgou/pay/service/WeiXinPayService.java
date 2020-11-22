package com.changgou.pay.service;

import java.util.Map;


public interface WeiXinPayService {

    /**
     * 关闭支付
     * @param orderId
     * @return
     * @throws Exception
     */
    Map<String,String> closePay(Long orderId) ;


    /**
     * 创建二维码参数
     * @param params
     * @return
     */
    Map<String ,String> createNative(Map<String, String> params);

    /**
     * 查询订单的支付状态
     * @param out_trade_no
     * @return
     */
    Map<String ,String> queryStatus(String out_trade_no);

}
