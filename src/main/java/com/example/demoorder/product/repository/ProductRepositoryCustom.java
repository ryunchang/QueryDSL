package com.example.demoorder.product.repository;

import com.example.demoorder.product.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepositoryCustom {


  List<ProductEntity> getProductList(String category);

}
