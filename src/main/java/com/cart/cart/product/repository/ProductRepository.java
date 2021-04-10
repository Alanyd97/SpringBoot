package com.cart.cart.product.repository;

import com.cart.cart.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    /*@Query("Select t from Tipo t where t.tipo = :tipo")
    List<Tipo> getTipo(@Param("tipo") String tipo);*/

}
