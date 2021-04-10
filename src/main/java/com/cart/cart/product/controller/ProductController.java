package com.cart.cart.product.controller;

import com.cart.cart.product.domain.Product;
import com.cart.cart.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("products/{id}")
    public ResponseEntity<Product> getByCategory(@PathVariable Integer id) {
        return new ResponseEntity(productService.findAllByCategory(id), HttpStatus.OK);
    }
}
