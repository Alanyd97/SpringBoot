package com.cart.cart.product.service;

import com.cart.cart.product.controller.response.ProductResponse;
import com.cart.cart.product.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllByCategory(Integer id);
}
