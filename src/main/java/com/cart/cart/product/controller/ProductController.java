package com.cart.cart.product.controller;

import com.cart.cart.product.controller.request.ProductRequest;
import com.cart.cart.product.domain.Product;
import com.cart.cart.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getByCategory(@PathVariable Integer id) {
        return new ResponseEntity(productService.findAllByCategory(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductRequest productRequest) {
        return new ResponseEntity(productService.create(productRequest), HttpStatus.OK);
    }
}
