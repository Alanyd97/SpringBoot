package com.cart.cart.product.repository;

import com.cart.cart.common.State;
import com.cart.cart.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("Select p from Product p where p.state = :state")
    List<Product> getAllByState(@Param("state") State state);

}
