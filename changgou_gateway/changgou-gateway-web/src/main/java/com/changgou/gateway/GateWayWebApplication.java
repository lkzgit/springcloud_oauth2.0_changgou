package com.changgou.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableEurekaClient
public class GateWayWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayWebApplication.class,args);
    }

    /***
     * IP限流
     * KeyResolver用于计算某一个类型的限流的KEY也就是说，可以通过KeyResolver来指定限流的Key。
     *
     *  网关限流：
     *  1、令牌桶算法
     *  2、漏桶算法
     *  3、计数算法
     *  未达到流量阈值--放行请求
     *  达到流量阈值--返回429
     */
    @Bean(name = "ipKeyResolver")
    public KeyResolver keyResolver() {
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                // 获取远程客户端IP
                String hostAddress = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
                System.out.println("hostAddress Ip:" + hostAddress);
                return Mono.just(hostAddress);
            }
        };
    }



}
