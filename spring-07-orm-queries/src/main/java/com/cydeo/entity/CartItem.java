package com.cydeo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class CartItem extends BaseEntity {

    private Integer quantity;
    @ManyToOne
    private Cart cart;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

}
