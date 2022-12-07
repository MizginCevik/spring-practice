package com.cydeo.service;

import com.cydeo.dto.DiscountDTO;

import java.util.List;

public interface DiscountService {

    List<DiscountDTO> getDiscountList();
    DiscountDTO getDiscountListByName(String name);
    DiscountDTO createDiscount(DiscountDTO discountDTO);
    DiscountDTO updateDiscount(DiscountDTO discountDTO);

}
