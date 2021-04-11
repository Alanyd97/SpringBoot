package com.cart.cart.cart.service;

import com.cart.cart.cart.controller.request.CartRequest;
import com.cart.cart.cart.domain.Cart;

public interface CartService {
    Cart create(CartRequest cartRequest);
}
