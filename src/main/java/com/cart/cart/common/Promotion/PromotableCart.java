package com.cart.cart.common.Promotion;

import com.cart.cart.cart.domain.Cart;

public class PromotableCart implements PromotionStrategy{

    @Override
    public double getFinalPrice(Cart cart) {

        return cart.getPrice_final() - price;
    }
}
