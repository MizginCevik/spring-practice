package com.cydeo.controller;

import com.cydeo.dto.ProductDTO;
import com.cydeo.dto.ProductRequest;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(new ResponseWrapper("Product is created.", productService.createProduct(productDTO), HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(new ResponseWrapper("Product is updated.", productService.updateProduct(productDTO), HttpStatus.OK));
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getProductList() {
        return ResponseEntity.ok(new ResponseWrapper("Product is updated.", productService.getProductList(), HttpStatus.OK));
    }

    @GetMapping("/top3")
    public ResponseEntity<ResponseWrapper> getTop3ProductList() {
        return ResponseEntity.ok(new ResponseWrapper("Top Three Product are retrieved.", productService.getTop3ProductList(), HttpStatus.OK));
    }

    @GetMapping("{name}")
    public ResponseEntity<ResponseWrapper> getProductListByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(new ResponseWrapper("Product is retrieved.", productService.getProductListByName(name), HttpStatus.OK));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<ResponseWrapper> getProductListByCategory(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new ResponseWrapper("Product is retrieved.", productService.getProductListByCategory(id), HttpStatus.OK));
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<ResponseWrapper> getProductListByPrice(@PathVariable("price") BigDecimal price) {
        return ResponseEntity.ok(new ResponseWrapper("Product is retrieved.", productService.getProductListByPrice(price), HttpStatus.OK));
    }

    @PostMapping("/categoryandprice")
    public ResponseEntity<ResponseWrapper> getProductListByPriceAndQuantity(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(new ResponseWrapper("Product is retrieved.", productService.getProductListByPriceAndQuantity(productRequest), HttpStatus.OK));
    }

}
