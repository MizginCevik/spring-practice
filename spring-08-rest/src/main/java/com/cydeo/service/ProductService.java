package com.cydeo.service;

import com.cydeo.dto.ProductDTO;
import com.cydeo.dto.ProductRequest;
import com.cydeo.entity.Category;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    ProductDTO create(ProductDTO productDTO);
    ProductDTO update(ProductDTO productDTO);
    List<ProductDTO> findAll();
    List<ProductDTO> findTop3();
    ProductDTO findByName(String name);
    List<ProductDTO> findByCategory(Long id);
    Integer findByPrice(BigDecimal price);
    List<ProductDTO> findByPriceAndQuantity(ProductRequest productRequest);

}
