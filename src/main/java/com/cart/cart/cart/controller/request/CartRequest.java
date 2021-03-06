package com.cart.cart.cart.controller.request;
import com.cart.cart.common.State;


import com.cart.cart.cartItem.controller.request.CartItemRequest;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartRequest {

    @NotNull
    private List<CartItemRequest> shopping_id_List;

    private Double price_final;
    private State type;
}
