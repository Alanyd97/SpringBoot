package com.cart.cart.common.Promotion;
import com.cart.cart.cart.domain.Cart;
import com.cart.cart.common.Promotion.PromotionStrategy;

public class SimpleCart implements PromotionStrategy{


    @Override
    public double getFinalPrice(Cart cart) {
        double price = cart.getPrice_final();
        price = (price / 100) * 10;
        return cart.getPrice_final() - price;
    }
}
