package com.cart.cart.product.service.impl;

import com.cart.cart.product.controller.response.ProductResponse;
import com.cart.cart.product.domain.Product;
import com.cart.cart.product.repository.ProductRepository;
import com.cart.cart.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;


    @Override
    public List<Product> findAllByCategory(Integer id) {
        return null;
    }
}
