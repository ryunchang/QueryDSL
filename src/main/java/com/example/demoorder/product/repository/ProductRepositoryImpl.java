package com.example.demoorder.product.repository;

import com.example.demoorder.product.entity.ProductEntity;
import com.example.demoorder.product.entity.QProductEntity;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepositoryCustom {

  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public List<ProductEntity> getProductList(String category) {
    QProductEntity product = QProductEntity.productEntity;
    return jpaQueryFactory.selectFrom(product)
            .from(product)
            .where(product.category.eq(category))
            .fetch();
  }
}
