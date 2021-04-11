package com.cart.cart.cartItem.service.impl;

import com.cart.cart.cartItem.controller.request.CardItemToList;
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
    public CartItem create(CartItemRequest cartItemRequest) {
        verifyItemFromRequest(cartItemRequest);
        Product product = productRepository.findById(cartItemRequest.getProduct()).get();
        CartItem cartItem = setCartItem(cartItemRequest, product);
        productService.updateStock(product,product.getStock()-cartItemRequest.getQuantity());
        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem getById(Integer id) {
        Optional<CartItem> optionalCartItem = cartItemRepository.findById(id);
        if(optionalCartItem.isEmpty()){throw new NotFoundException("El item que desea acceder no se encuentra en la base");}
        return optionalCartItem.get();
    }

    @Override
    public void removeItem(CartItem cartItem) {
        CartItem item = getById(cartItem.getId());
        productService.updateStock(cartItem.getProduct(), cartItem.getProduct().getStock() + cartItem.getQuantity());
        try{
            cartItemRepository.delete(item);
        }catch (NotFoundException e){
            throw new NotFoundException("error al tratar de borrar un item del carrito");
        }
    }

    @Override
    public List<CartItem> update(List<CardItemToList> cartItemList) {
        List<CartItem> cartItemListToResponse = new ArrayList<>();
        for (CardItemToList cardItemToList: cartItemList
             ) {
            verifyItem(cardItemToList);
            Optional<CartItem> optionalCartItem = cartItemRepository.findById(cardItemToList.getId());
            if(optionalCartItem.isEmpty()){throw new NotFoundException("El item no se encuentra en la base");}
            CartItem cartItem = optionalCartItem.get();
            Product product = cartItem.getProduct();
            CartItem currentItem = setCartItem(cardItemToList, product);
            productService.updateStock(product,product.getStock() + (cartItem.getQuantity() - currentItem.getQuantity()));
            currentItem.setId(cardItemToList.getId());
            cartItemListToResponse.add(cartItemRepository.save(currentItem));
        }
        return cartItemListToResponse;
    }


    private void verifyItemFromRequest(CartItemRequest cartItemRequest){
        Integer productId = cartItemRequest.getProduct();
        if(productId == null || productId<=0){
            throw new BadRequestException("El producto no debe ser nulo o menor a cero");
        }
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isEmpty()){
            throw new NotFoundException("El producto al que desea acceder no se encuentra en la base");
        }
        if(optionalProduct.get().getStock() < cartItemRequest.getQuantity()){
            throw new BadRequestException("La cantidad a comprar supera al stock actual del producto");
        }
        if (cartItemRequest.getQuantity() == null || cartItemRequest.getQuantity() <= 0){
            throw new BadRequestException("La cantidad no debe ser nula, menor o igual a cero, o sobrepasar el stock del producto");
        }
    }

    private void verifyItem(CardItemToList cartItem){
      if (cartItem.getQuantity() <= 0){ throw new BadRequestException("la cantidad no debe ser menor o igual a 0"); }
      if(cartItem.getId() <= 0){ throw new BadRequestException("El id del item no debe ser menor o igual a 0");}
      if(cartItem.getProduct()< 0){throw new BadRequestException("El id del producto no puede ser menor a 0");}
    }

    private CartItem setCartItem(CartItemRequest cartItemRequest, Product product) {
        Integer quantity = cartItemRequest.getQuantity();
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setPrice_sub(quantity * product.getPrice());
        cartItem.setQuantity(cartItemRequest.getQuantity());
        return  cartItem;
    }

}
