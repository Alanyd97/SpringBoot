package com.cart.cart.product.controller.request;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductRequest {

    private String name;

    private Double price;

    private Integer stock;


}
