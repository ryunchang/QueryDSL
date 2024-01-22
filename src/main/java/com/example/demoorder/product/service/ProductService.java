package com.example.demoorder.product.service;

import com.example.demoorder.product.dto.GetProductResponse;
import com.example.demoorder.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public List<GetProductResponse> getProductList(String category) {

    // queryDSL를 이용한 where = category 조회 로직 실습

    List<GetProductResponse> response;

    if(Objects.isNull(category)){
      response = productRepository.findAll().stream()
              .map(m ->
                      GetProductResponse.builder()
                              .name(m.getName())
                              .price(m.getPrice())
                              .category(m.getCategory())
                              .build())
              .collect(Collectors.toList());
    }else{
      response = productRepository.getProductList(category).stream()
              .map(m ->
                      GetProductResponse.builder()
                              .name(m.getName())
                              .price(m.getPrice())
                              .category(m.getCategory())
                              .build())
              .collect(Collectors.toList());
    }
    return response;
  }

}
