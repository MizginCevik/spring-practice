package com.cydeo.service;

import com.cydeo.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getCustomerList();
    CustomerDTO getCustomerListByEmail(String email);
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(CustomerDTO customerDTO);

}
