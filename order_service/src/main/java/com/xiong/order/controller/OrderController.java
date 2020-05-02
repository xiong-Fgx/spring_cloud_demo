package com.xiong.order.controller;

import com.xiong.order.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    /*
    * 参数：商品id
    * 通过订单系统，调用商品服务，根据id查询商品信息
    * 1. 需要配置商品对象
    * 2. 需要调用商品服务
    * */

    // 这里需要通过order_service 去调用 product_service中的查询接口
    // 可以使用java中的urlconnection，httpclient，okhttp等接口来调用其接口
    // 但是也可以使用RestTemplate来调用其他人的服务接口

    // 注入RestTemplate对象，该对象是在启动类中定义并交由容器管理的
    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/buy/{id}", method = RequestMethod.GET)
    public Product findById(@PathVariable Long id) {
        Product product = null;

        // 借助 restTemplate 进行远程调用
        // 第一个参数是要请求的url，第二个参数是想要让它转化成为的对象的字节码
        product = restTemplate.getForObject("http://127.0.0.1:9001/product/2", Product.class);

        return product;
    }
}
