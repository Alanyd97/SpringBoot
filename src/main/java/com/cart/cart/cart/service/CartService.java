package com.cart.cart.cart.service;

import com.cart.cart.cart.controller.request.CartRequest;
import com.cart.cart.cart.domain.Cart;
import com.cart.cart.cartItem.controller.request.CartItemRequest;
import org.springframework.http.HttpStatus;

public interface CartService {
    Cart create(CartRequest cartRequest);

    Cart addItem(Integer id, CartItemRequest cartItemRequest);

    Cart removeItem(Integer id_cart, Integer id_item);

    Cart getById(Integer id);

    HttpStatus remove(Integer id);
}
