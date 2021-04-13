package com.cart.cart.common.Promotion;
import com.cart.cart.cart.domain.Cart;

public interface PromotionStrategy {
    double getFinalPrice(Cart cart);
}
