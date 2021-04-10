package com.cart.cart.product.domain;

import com.cart.cart.common.Estado;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private double price;

    @Column
    private Integer stock;

    @Column
    private Estado estado;


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
