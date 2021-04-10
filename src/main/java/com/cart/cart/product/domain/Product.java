package com.cart.cart.product.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private double price;

    @Column
    private Integer stock;

    @Column
    private Enum estado;

}
