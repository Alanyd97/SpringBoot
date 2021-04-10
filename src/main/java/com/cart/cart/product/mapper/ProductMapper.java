package com.cart.cart.product.mapper;

import com.cart.cart.product.controller.response.ProductResponse;
import com.cart.cart.product.domain.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    List<ProductResponse> toProductResponseList(List<Product> productList);
    ProductResponse toProductResponse(Product product);
}
