package com.cart.cart.cartItem.service;

import com.cart.cart.cartItem.controller.request.CardItemToList;
import com.cart.cart.cartItem.controller.request.CartItemRequest;
import com.cart.cart.cartItem.domain.CartItem;

import java.util.List;

public interface CartItemService {

    List<CartItem> createAll(List<CartItemRequest> cartItemRequestList);

    CartItem create(CartItemRequest cartItemRequest);

    CartItem getById(Integer id);

    void removeItem(CartItem cartItem);

    List<CartItem> update(List<CardItemToList> cartItem);

}
