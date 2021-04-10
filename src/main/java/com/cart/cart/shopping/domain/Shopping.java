package com.cart.cart.shopping.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Shopping {
    @Id
    @GeneratedValue
    private Integer id;
}
