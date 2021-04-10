package com.cart.cart.product.service;

import com.cart.cart.product.controller.request.ProductRequest;
import com.cart.cart.product.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllByCategory(Integer id);

    Product create(ProductRequest productRequest);
}
