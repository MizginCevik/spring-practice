package com.cydeo.model;

import com.cydeo.proxy.QuantityType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ingredients {
    private String name;
    private Long quantity;
    private QuantityType quantityType;
}
