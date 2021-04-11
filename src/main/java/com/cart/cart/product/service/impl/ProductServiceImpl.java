package com.cart.cart.product.service.impl;

import com.cart.cart.common.Estado;
import com.cart.cart.common.config.exception.BadRequestException;
import com.cart.cart.product.controller.request.ProductRequest;
import com.cart.cart.product.domain.Product;
import com.cart.cart.product.repository.ProductRepository;
import com.cart.cart.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;


    @Override
    public List<Product> findAllByCategory() {
        return productRepository.findAll();
    }

    @Override
    public Product create(ProductRequest productRequest) {
        return productRepository.save(productRequestToProduct(productRequest));
    }

    @Override
    public Product updateStock(Product product, Integer quantity) {
        product.setStock(quantity);
        return product;
    }

    private Product productRequestToProduct(ProductRequest productRequest){
        verifyItem(productRequest);
        Product product = new Product();
        product.setEstado(Estado.ACTIVO);
        product.setPrice(productRequest.getPrice());
        product.setName(productRequest.getName());
        product.setStock(productRequest.getStock());
        return product;
    }

    private void verifyItem(ProductRequest  productRequest){
        String name = productRequest.getName();
        Double price = productRequest.getPrice();
        Integer stock = productRequest.getStock();
        if(name == null || name == "" || name == " "){ throw new BadRequestException("El nombre del producto no debe ser vacio");}
        if( price == null  || price <= 0|| price.isNaN()){ throw new BadRequestException("El precio del producto no debe ser vacio, menor o igual a 0");}
        if(stock == null || stock < 0){ throw new BadRequestException("El stock del producto no debe ser vacio o menor a 0");}
    }


}
