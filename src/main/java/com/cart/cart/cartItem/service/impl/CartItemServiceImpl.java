package com.cart.cart.cartItem.service.impl;

import com.cart.cart.cart.controller.request.CartRequest;
import com.cart.cart.cartItem.controller.request.CartItemRequest;
import com.cart.cart.cartItem.domain.CartItem;
import com.cart.cart.cartItem.repository.CartItemRepository;
import com.cart.cart.cartItem.service.CartItemService;
import com.cart.cart.common.config.exception.BadRequestException;
import com.cart.cart.common.config.exception.NotFoundException;
import com.cart.cart.product.domain.Product;
import com.cart.cart.product.repository.ProductRepository;
import com.cart.cart.product.service.ProductService;
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
    @Autowired
    ProductService productService;

    @Override
    public List<CartItem> createAll(List<CartItemRequest> cartItemRequestList) {
        List<CartItem> cartItems = shoppingRequestListToShoppingList(cartItemRequestList);
        List<CartItem> cartItemList = cartItemRepository.saveAll(cartItems);
        return null;
    }


    private List<CartItem> shoppingRequestListToShoppingList(List<CartItemRequest> cartItemRequestList) {
        Double price = 0.00;
        Integer quantity = 0;
        List<CartItem> cartItemList = new ArrayList<>();
        for (CartItemRequest item: cartItemRequestList) {
            Optional<Product> optionalProduct = productRepository.findById(item.getProduct());
            if (optionalProduct.isEmpty()){ throw new NotFoundException("entidad no encontrada"); }
            verifyItem(item);
            CartItem cartItem = setCartItem(item);
            cartItemList.add(cartItem);
        }
        return cartItemList;
    }

    private CartItem setCartItem(CartItemRequest cartItemRequest) {
        Product product = productRepository.findById(cartItemRequest.getProduct()).get();
        Integer quantity = cartItemRequest.getQuantity();
        productService.updateStock(product,quantity);
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setPrice_sub(quantity * product.getPrice());
        cartItem.setQuantity(cartItemRequest.getQuantity());
        return  cartItem;
    }

    private void verifyItem(CartItemRequest cartItemRequest){
        Integer productId = cartItemRequest.getProduct();
        if(productId == null || productId<=0){
            throw new BadRequestException("El producto no debe ser nulo o menor a cero");
        }
        if(!productRepository.existsById(productId)){
            throw new NotFoundException("El producto al que desea acceder no se encuentra en la base");
        }
        if (cartItemRequest.getQuantity() == null || cartItemRequest.getQuantity() <= 0){
            throw new BadRequestException("La cantidad no debe ser nula, menor o igual a cero, o sobrepasar el stock del producto");
        }
    }


    @Override
    public CartItem create(CartItemRequest cartItemRequest) {
        verifyItem(cartItemRequest);
        CartItem cartItem = setCartItem(cartItemRequest);
        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem getById(Integer id) {
        return null;
    }
}
