package com.cart.cart.cartItem.controller;

import com.cart.cart.cart.controller.request.CartRequest;
import com.cart.cart.cart.domain.Cart;
import com.cart.cart.cartItem.domain.CartItem;
import com.cart.cart.cartItem.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class CartItemController {
    @Autowired
    CartItemService cartItemService;

    @PostMapping("/update-items")
    public ResponseEntity<List<CartItem>> updateItems(@RequestParam List<CartItem> cartItemList){
        return new ResponseEntity(cartItemService.update(cartItemList), HttpStatus.OK);
    }
}
