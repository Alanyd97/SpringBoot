package com.cart.cart.cartItem.controller.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemRequest {
    @NotNull
    private Integer product;
    @NotNull
    private Integer quantity;

}
