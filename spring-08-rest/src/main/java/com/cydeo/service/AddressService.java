package com.cydeo.service;

import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.CustomerDTO;

import java.util.List;

public interface AddressService {

    List<AddressDTO> findAll();
    AddressDTO create(AddressDTO addressDTO);
    AddressDTO update(AddressDTO addressDTO);
    List<AddressDTO> findByCustomerId(Long id);
    List<AddressDTO> findByStartsWithAddress(String pattern);
    List<AddressDTO> findByCustomerAndName(Long id, String name);

}
