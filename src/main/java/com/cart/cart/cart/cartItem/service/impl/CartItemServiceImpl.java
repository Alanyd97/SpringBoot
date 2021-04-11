package com.cart.cart.cart.cartItem.service.impl;

import com.cart.cart.cart.cartItem.controller.request.CartItemRequest;
import com.cart.cart.cart.cartItem.domain.CartItem;
import com.cart.cart.cart.cartItem.repository.CartItemRepository;
import com.cart.cart.cart.cartItem.service.CartItemService;
import com.cart.cart.common.config.exception.BadRequestException;
import com.cart.cart.common.config.exception.NotFoundException;
import com.cart.cart.product.domain.Product;
import com.cart.cart.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<CartItem> createAll(List<CartItemRequest> cartItemRequestList) {
        List<CartItem> cartItemList = shoppingRequestListToShoppingList(cartItemRequestList);
        return cartItemRepository.saveAll(cartItemList);
    }

    private List<CartItem> shoppingRequestListToShoppingList(List<CartItemRequest> cartItemRequestList) {
        Double price = 0.00;
        Integer quantity = 0;
        List<CartItem> cartItemList = new ArrayList<>();
        for (CartItemRequest item: cartItemRequestList) {
            Optional<Product> optionalProduct = productRepository.findById(item.getProduct());
            if (optionalProduct.isEmpty()){ throw new NotFoundException("entidad no encontrada"); }

            Product product = optionalProduct.get();
            verifyItem(item, product);
            quantity = item.getQuantity();
            price = getSubPrice(price, product.getPrice(),quantity);

            CartItem cartItem = setCartItem(product, price, quantity);
            cartItemList.add(cartItem);
        }
        return cartItemList;
    }

    private CartItem setCartItem(Product product, Double price, Integer quantity) {
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setPrice_sub(price);
        cartItem.setQuantity(quantity);
        return  cartItem;
    }

    private Double getSubPrice(Double price, Double productPrice, Integer quantity){
        return price + (productPrice * quantity);
    }

    private void verifyItem(CartItemRequest cartItemRequest, Product product){
        if (cartItemRequest.getQuantity() == null || cartItemRequest.getQuantity() <= 0 || cartItemRequest.getQuantity() > product.getStock() ){
            throw new BadRequestException("La cantidad no debe ser nula, menor o igual a cero, o sobrepasar el stock del producto");
        }
    }


}
