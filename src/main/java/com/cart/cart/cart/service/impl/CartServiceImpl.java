package com.cart.cart.cart.service.impl;

import com.cart.cart.cart.controller.request.CartRequest;
import com.cart.cart.cart.domain.Cart;
import com.cart.cart.cart.repository.CartRepository;
import com.cart.cart.cart.service.CartService;
import com.cart.cart.cartItem.controller.request.CartItemRequest;
import com.cart.cart.cartItem.domain.CartItem;
import com.cart.cart.cartItem.repository.CartItemRepository;
import com.cart.cart.cartItem.service.CartItemService;
import com.cart.cart.common.Estado;
import com.cart.cart.common.config.exception.BadRequestException;
import com.cart.cart.common.config.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartItemService cartItemService;

    @Override
    public Cart create(CartRequest cartRequest) {
        return cartRepository.save(setNewCart());
    }

    @Override
    public Cart addItem(Integer id, CartItemRequest cartItemRequest) {
        Optional<Cart> optionalCart = cartRepository.findById(id);
        if (optionalCart.isEmpty()){throw new NotFoundException("El carrito no se encuentra en la base");}
        Cart cart = optionalCart.get();
        List<CartItem> cartItemList = cart.getCartItemList();
        if(cartItemList == null){ cartItemList = new ArrayList<>(); }
        CartItem cartItem = cartItemService.create(cartItemRequest);
        cartItemList.add(cartItem);
        cart.setPrice_final(cart.getPrice_final() + cartItem.getPrice_sub());
        cart.setCartItemList(cartItemList);
        cart.setId(id);
        return cartRepository.save(cart);
    }

    @Override
    public Cart removeItem(Integer id_cart, Integer id_item) {
        Optional<Cart> optionalCart = cartRepository.findById(id_cart);
        if (optionalCart.isEmpty()){throw new NotFoundException("El carrito no se encuentra en la base");}
        CartItem cartItem = cartItemService.getById(id_item);
        Cart cart = optionalCart.get();
        List<CartItem> cartItemList = cart.getCartItemList();
        cartItemList = removeItemFromCart(cartItemList, cartItem);
        cart.setCartItemList(cartItemList);
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public Cart getById(Integer id) {
        Optional<Cart> optionalCart = cartRepository.findById(id);
        if(optionalCart.isEmpty()){throw new NotFoundException("El carro que desea acceder no se encuentra en la base");}
        return optionalCart.get();
    }

    private Cart setNewCart(){
        Cart cart = new Cart();
        cart.setEstado(Estado.ACTIVO);
        cart.setCartItemList(new ArrayList<>());
        cart.setPrice_final(0.00);
        return cart;
    }

    private List<CartItem> removeItemFromCart(List<CartItem> cartItemList, CartItem cartItem){
        for (CartItem item: cartItemList
             ) {
            if(item.equals(cartItem)){
                cartItemList.remove(item);
                cartItemService.removeItem(item);
                return cartItemList;
            }
        }
        throw new BadRequestException("el item que desea borrar no pertenece al carrito actual");
    }
}
