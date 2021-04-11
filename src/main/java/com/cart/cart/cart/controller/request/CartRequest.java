package com.cart.cart.cart.controller.request;


import com.cart.cart.cart.cartItem.controller.request.CartItemRequest;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartRequest {

    @NotNull
    private List<CartItemRequest> shopping_id_List;
}
