package com.cart.cart.common.PromotionFactory;

import com.cart.cart.common.Promotion.PromotableCart;
import com.cart.cart.common.Promotion.PromotionStrategy;
import com.cart.cart.common.Promotion.SimpleCart;
import com.cart.cart.common.Type;

public class PromotionFactory {
    public PromotionStrategy getPromotion(Type type){
        if(type == Type.PROMOCIONABLE){
            return new PromotableCart();
        }
        return new SimpleCart();
    }
}
