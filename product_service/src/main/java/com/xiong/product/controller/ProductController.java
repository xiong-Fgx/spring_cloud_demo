package com.xiong.product.controller;

import com.xiong.product.entity.Product;
import com.xiong.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// restful 风格的服务
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    // 根据对象查询返回
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    // 保存对象
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String save(@RequestBody Product product) {
        productService.save(product);
        return "保存成功";
    }
}
