package com.xiong.product.dao;

import com.xiong.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

// 接口需要继承两个接口
// 可以通过jpa实现自动的增删改查功能
public interface ProductDao extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

}
