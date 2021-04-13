package com.cart.cart.cart.domain;

import com.cart.cart.cartItem.domain.CartItem;
import com.cart.cart.common.State;
import com.cart.cart.common.Type;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> cartItemList;

    @Column
    private Double price_final;

    @Column
    private State state;

    @Column
    private Type type;




}
