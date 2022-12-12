package com.cydeo.controller;

import com.cydeo.dto.CustomerDTO;
import com.cydeo.model.ResponseWrapper;
import com.cydeo.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getCustomerList() {
        return ResponseEntity.ok(new ResponseWrapper("Customer List is retrieved.", customerService.findAll(), HttpStatus.OK));
    }

    @GetMapping("/{email}")
    public ResponseEntity<ResponseWrapper> getCustomerByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(new ResponseWrapper("Customer is retrieved by using email.", customerService.findByEmail(email), HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(new ResponseWrapper("Customer is created.", customerService.create(customerDTO), HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(new ResponseWrapper("Customer is updated.", customerService.update(customerDTO), HttpStatus.OK));
    }

}
