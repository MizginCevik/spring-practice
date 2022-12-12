package com.cydeo.controller;

import com.cydeo.dto.DiscountDTO;
import com.cydeo.model.ResponseWrapper;
import com.cydeo.service.DiscountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/discount")
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getDiscountList() {
        return ResponseEntity.ok(new ResponseWrapper("Discount List is retrieved.", discountService.findAll(), HttpStatus.OK));
    }

    @GetMapping("{name}")
    public ResponseEntity<ResponseWrapper> getDiscountByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(new ResponseWrapper("Discount is retrieved by using name.", discountService.findByName(name), HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createDiscount(@RequestBody DiscountDTO discountDTO) {
        return ResponseEntity.ok(new ResponseWrapper("Discount is created.", discountService.create(discountDTO), HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateDiscount(@RequestBody DiscountDTO discountDTO) {
        return ResponseEntity.ok(new ResponseWrapper("Discount is updated.", discountService.update(discountDTO), HttpStatus.OK));
    }

}
