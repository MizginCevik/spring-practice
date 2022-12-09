package com.cydeo.service;

import com.cydeo.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO findById(Long id);
    List<CustomerDTO> findAll();
    CustomerDTO findByEmail(String email);
    CustomerDTO create(CustomerDTO customerDTO);
    CustomerDTO update(CustomerDTO customerDTO);

}
