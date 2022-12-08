package com.cydeo.service.impl;

import com.cydeo.dto.ProductDTO;
import com.cydeo.dto.ProductRequest;
import com.cydeo.entity.Category;
import com.cydeo.entity.Product;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.ProductRepository;
import com.cydeo.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final MapperUtil mapperUtil;

    public ProductServiceImpl(ProductRepository productRepository, MapperUtil mapperUtil) {
        this.productRepository = productRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        productRepository.save(mapperUtil.convert(productDTO, new Product()));
        return productDTO;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        Product product = mapperUtil.convert(productDTO, new Product());
        productRepository.save(product);
        return productDTO;
    }

    @Override
    public List<ProductDTO> getProductList() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getTop3ProductList() {
        List<Product> productList = productRepository.findTop3ByOrderByPriceDesc();
        return productList.stream().map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductListByName(String name) {
        Product product = productRepository.findFirstByName(name);
        return mapperUtil.convert(product, new ProductDTO());
    }

    @Override
    public List<ProductDTO> getProductListByCategory(Long id) {
        List<Product> productList = productRepository.retrieveProductListByCategory(id);
        return productList.stream().map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }

    @Override
    public Integer getProductListByPrice(BigDecimal price) {
        Integer count = productRepository.countProductByPriceGreaterThan(price);
        return count;
    }

    @Override
    public List<ProductDTO> getProductListByPriceAndQuantity(ProductRequest productRequest) {
        List<Product> productList = productRepository.retrieveProductListByCategory(productRequest.getCategoryList(), productRequest.getPrice());
        return productList.stream().map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }

}
