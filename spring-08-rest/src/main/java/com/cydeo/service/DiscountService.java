package com.cydeo.service;

import com.cydeo.dto.DiscountDTO;

import java.util.List;

public interface DiscountService {

    List<DiscountDTO> findAll();
    DiscountDTO findByName(String name);
    DiscountDTO create(DiscountDTO discountDTO);
    DiscountDTO update(DiscountDTO discountDTO);

}
