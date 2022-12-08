package com.cydeo.controller;

import com.cydeo.dto.AddressDTO;

import com.cydeo.model.ResponseWrapper;
import com.cydeo.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAddressList() {
        return ResponseEntity.ok(new ResponseWrapper("Address List is retrieved.", addressService.findAll(), HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createAddress(@RequestBody AddressDTO addressDTO) {
        return ResponseEntity.ok(new ResponseWrapper("Address is created.", addressService.create(addressDTO), HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateAddress(@RequestBody AddressDTO addressDTO) {
        return ResponseEntity.ok(new ResponseWrapper("Address is updated.", addressService.update(addressDTO), HttpStatus.OK));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<ResponseWrapper> getAddressListByCustomerId(@PathVariable("id") Long customerId) {
        return ResponseEntity.ok(new ResponseWrapper("Address is retrieved by using customer id.", addressService.findByCustomerId(customerId), HttpStatus.OK));
    }

    @GetMapping("/startsWith/{address}")
    public ResponseEntity<ResponseWrapper> getAddressListByStartsWithAddress(@PathVariable("address") String address) {
        return ResponseEntity.ok(new ResponseWrapper("Address is retrieved by using customer id.", addressService.findByStartsWithAddress(address), HttpStatus.OK));
    }

    @GetMapping("/customer/{customerId}/name/{name}")
    public ResponseEntity<ResponseWrapper> getAddressListByCustomerAndName(@PathVariable("customerId") Long customerId, @PathVariable("name") String name) {
        return ResponseEntity.ok(new ResponseWrapper("Address is retrieved by using customer id.", addressService.findByCustomerAndName(customerId,name), HttpStatus.OK));
    }

}
