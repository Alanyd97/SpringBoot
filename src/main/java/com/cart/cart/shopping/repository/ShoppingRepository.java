package com.cart.cart.shopping.repository;

import com.cart.cart.shopping.domain.Shopping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingRepository extends JpaRepository<Shopping, Integer> {
}
