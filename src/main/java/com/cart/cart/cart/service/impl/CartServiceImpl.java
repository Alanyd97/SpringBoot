package com.cart.cart.cart.service.impl;

import com.cart.cart.cart.controller.request.CartRequest;
import com.cart.cart.cart.domain.Cart;
import com.cart.cart.cart.repository.CartRepository;
import com.cart.cart.cart.service.CartService;
import com.cart.cart.cartItem.domain.CartItem;
import com.cart.cart.cartItem.service.CartItemService;
import com.cart.cart.common.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartItemService cartItemService;

    @Override
    public Cart create(CartRequest cartRequest) {
        return cartRepository.save(getCart());
    }

    private Cart getCart(){
        Cart cart = new Cart();
        cart.setEstado(Estado.ACTIVO);
        return cart;
    }
}
