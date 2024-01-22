package com.example.demoorder.product.controller;

import com.example.demoorder.product.dto.GetProductResponse;
import com.example.demoorder.product.service.ProductService;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping("/api/v1/product")
  public List<GetProductResponse> getProductList(@Nullable @RequestParam("category") String category) {

    return productService.getProductList(category);
  }

}
