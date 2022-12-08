package com.cydeo.service;

import com.cydeo.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    ProductDTO create(ProductDTO productDTO);
    ProductDTO update(ProductDTO productDTO);
    List<ProductDTO> findAll();
    List<ProductDTO> findTop3();
    ProductDTO findByName(String name);
    List<ProductDTO> findByCategory(Long id);
    Integer findCountByPrice(BigDecimal price);
    List<ProductDTO> findByCategoryAndPrice(List<Long> categoryList, BigDecimal price);
    List<ProductDTO> findByPriceAndQuantity(BigDecimal price, Integer quantity);

}
