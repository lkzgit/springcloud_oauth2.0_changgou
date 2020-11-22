package com.changgou.goods;

import entity.FeignInterceptor;
import entity.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.changgou.goods.dao"})
public class GoodsApplicarion {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplicarion.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(0,1) ;}




    @Bean
    public FeignInterceptor feignInterceptor(){
        return new FeignInterceptor();
    }


}
