package com.changgou.order.mq.queue;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 延时队列
 */
@Configuration
@Component
public class QueueConfig {

    /**
     * 创建队列1
     *
     */
    @Bean
    public Queue orderListenerQueue(){
        return new Queue("orderListenerQueue",true); // 是否持久化
    }

    /**
     * 创建队列2 延时队列 会过期，过期后将数据发送队列1
     */
    @Bean
    public Queue orderDelayQueue(){
        return QueueBuilder.durable("orderDelayQueue")
                .withArgument("x-dead-letter-exchange","dlx_exchange")//消息超时进入死信队列，绑定死信队列交换机
                .withArgument("x-dead-letter-routing-key","orderListenerQueue") //绑定指定的路由key
                .build();
    }

    /**
     * 创建交换机
     */
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("dlx_exchange");
    }

    /**
     * 队列2绑定交换机
     */
    @Bean
    public Binding basicBinding(Queue orderListenerQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(orderListenerQueue)
                .to(directExchange)
                .with("orderListenerQueue");
    }

}
