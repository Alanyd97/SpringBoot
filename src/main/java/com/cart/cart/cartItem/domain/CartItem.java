package com.cart.cart.cartItem.domain;

import com.cart.cart.product.domain.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue
    private Integer id;

    @JoinColumn
    @ManyToOne
    private Product product;

    @Column
    private Integer quantity;

    @Column
    private Double price_sub;



}
