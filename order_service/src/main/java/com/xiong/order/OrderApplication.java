package com.xiong.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EntityScan("com.xiong.product.entity")
public class OrderApplication {
    /*
    *  使用spring提供的 RestTemplate 发送http请求到商品服务，有两个步骤：
    *     1. 要创建出 RestTemplate ，交给容器管理
    *     2. 使用时调用其方法，完成操作，比如getXX postXX
    * */

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}
