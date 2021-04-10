package com.cart.cart.product.controller.request;

import com.cart.cart.common.Estado;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class ProductRequest {

    private String name;

    private Double price;

    private Integer stock;

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

}
