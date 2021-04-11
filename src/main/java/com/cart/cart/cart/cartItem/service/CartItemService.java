package com.cart.cart.cart.cartItem.service;

import com.cart.cart.cart.cartItem.controller.request.CartItemRequest;
import com.cart.cart.cart.cartItem.domain.CartItem;

import java.util.List;

public interface CartItemService {

    List<CartItem> createAll(List<CartItemRequest> cartItemRequestList);
}
