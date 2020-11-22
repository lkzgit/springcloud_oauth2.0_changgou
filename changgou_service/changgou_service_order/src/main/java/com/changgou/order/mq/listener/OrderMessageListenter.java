package com.changgou.order.mq.listener;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
@RabbitListener(queues = "${mq.pay.queue.order}")
public class OrderMessageListenter {

    /**
     * 支付结果监听
     */
    @RabbitHandler
    public void getMessage(String message){
        //支付结果
        Map<String,String> resultMap= JSON.parseObject(message,Map.class);
        System.out.println("监听到的支付消息："+resultMap);
        //通信表示 return_code
        String return_code = resultMap.get("return_code");
        if(return_code.equals("SUCCESS")){
            //业务结果 return_code
            String code = resultMap.get("result_code");
            //订单号
            String out_trade_no = resultMap.get("out_trade_no");
                //支付成功 修改订单状态
                if(code.equals("SUCCESS")){
                    System.out.println("支付成功修改订单状态：");
                }else{
                    //支付失败，关闭支付 ，取消订单 ，回滚库存
                    System.out.println("支付失败取消订单");
                }

        }
    }
}
