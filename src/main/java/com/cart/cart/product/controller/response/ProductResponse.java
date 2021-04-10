package com.cart.cart.product.controller.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private Integer id;

    private String name;

    private double price;

    private Integer stock;

    private Enum estado;
}
