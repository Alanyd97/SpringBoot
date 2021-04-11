package com.cart.cart.cart.controller;

import com.cart.cart.cart.controller.request.CartRequest;
import com.cart.cart.cart.domain.Cart;
import com.cart.cart.cart.service.CartService;
import com.cart.cart.cartItem.controller.request.CartItemRequest;
import com.cart.cart.product.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping
    public ResponseEntity<Cart> create(@RequestBody  CartRequest cartRequest) {
        return new ResponseEntity(cartService.create(cartRequest), HttpStatus.OK);
    }
    @PostMapping("/addItem/{id}")
    public  ResponseEntity<Cart> addItem(@RequestBody CartItemRequest cartItemRequest, @PathVariable Integer id){
        return new ResponseEntity(cartService.addItem(id, cartItemRequest), HttpStatus.OK);
    }


}
