package com.cydeo.service.impl;

import com.cydeo.dto.ProductDTO;
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
    public ProductDTO create(ProductDTO productDTO) {
        Product product = productRepository.save(mapperUtil.convert(productDTO, new Product()));
        return mapperUtil.convert(product, new ProductDTO());
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        Product product = productRepository.save(mapperUtil.convert(productDTO, new Product()));
        return mapperUtil.convert(product, new ProductDTO());
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findTop3() {
        List<Product> productList = productRepository.findTop3ByOrderByPriceDesc();
        return productList.stream().map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }

    @Override
    public ProductDTO findByName(String name) {
        Product product = productRepository.findFirstByName(name);
        return mapperUtil.convert(product, new ProductDTO());
    }

    @Override
    public List<ProductDTO> findByCategory(Long id) {
        List<Product> productList = productRepository.retrieveProductListByCategory(id);
        return productList.stream().map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }

    @Override
    public Integer findCountByPrice(BigDecimal price) {
        Integer count = productRepository.countProductByPriceGreaterThan(price);
        return count;
    }

    @Override
    public List<ProductDTO> findByCategoryAndPrice(List<Long> categoryList, BigDecimal price) {
        List<Product> productList = productRepository.retrieveProductListByCategory(categoryList, price);
        return productList.stream().map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findByPriceAndQuantity(BigDecimal price, Integer quantity) {
        List<Product> productList = productRepository.retrieveProductListGreaterThanPriceAndLowerThanRemainingQuantity(price,quantity);
        return productList.stream().map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }

}
