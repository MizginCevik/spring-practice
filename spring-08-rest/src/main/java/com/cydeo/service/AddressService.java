package com.cydeo.service;

import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.CustomerDTO;

import java.util.List;

public interface AddressService {

    List<AddressDTO> getAddressList();
    AddressDTO createAddress(AddressDTO addressDTO);
    AddressDTO updateAddress(AddressDTO addressDTO);
    List<AddressDTO> getAddressListByCustomerId(Long id);
    List<AddressDTO> getAddressListByStartsWithAddress(String pattern);
    List<AddressDTO> getAddressListByCustomerAndName(Long id, String name);

}
