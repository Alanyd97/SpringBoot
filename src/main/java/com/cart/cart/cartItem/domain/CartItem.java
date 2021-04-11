package com.cart.cart.cartItem.domain;

import com.cart.cart.cart.domain.Cart;
import com.cart.cart.product.domain.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
public class CartItem{
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return Objects.equals(id, cartItem.id);
    }
}
