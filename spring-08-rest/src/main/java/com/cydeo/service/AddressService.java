package com.cydeo.service;

import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.CustomerDTO;

import java.util.List;

public interface AddressService {

    List<AddressDTO> findAll();
    AddressDTO create(AddressDTO addressDTO);
    AddressDTO update(AddressDTO addressDTO);
    List<AddressDTO> findAllByCustomerId(Long id);
    List<AddressDTO> findAllByStartsWith(String pattern);
    List<AddressDTO> findAllByCustomerIdAndName(Long id, String name);

}
