package com.cydeo.service;

import com.cydeo.dto.ProductDTO;
import com.cydeo.dto.ProductRequest;
import com.cydeo.entity.Category;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(ProductDTO productDTO);
    List<ProductDTO> getProductList();
    List<ProductDTO> getTop3ProductList();
    ProductDTO getProductListByName(String name);
    List<ProductDTO> getProductListByCategory(Long id);
    Integer getProductListByPrice(BigDecimal price);
    List<ProductDTO> getProductListByPriceAndQuantity(ProductRequest productRequest);

}
