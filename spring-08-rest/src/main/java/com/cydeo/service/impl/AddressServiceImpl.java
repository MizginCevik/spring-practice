package com.cydeo.service.impl;

import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.CustomerDTO;
import com.cydeo.entity.Address;
import com.cydeo.entity.Customer;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.AddressRepository;
import com.cydeo.service.AddressService;
import com.cydeo.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final MapperUtil mapperUtil;
    private final CustomerService customerService;

    public AddressServiceImpl(AddressRepository addressRepository, MapperUtil mapperUtil, CustomerService customerService) {
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
        this.customerService = customerService;
    }

    @Override
    public List<AddressDTO> findAll() {
        List<Address> addressList = addressRepository.findAll();
        return addressList.stream().map(address -> mapperUtil.convert(address, new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public AddressDTO create(AddressDTO addressDTO) {
        Address address = mapperUtil.convert(addressDTO, new Address());

        CustomerDTO customer = customerService.findById(addressDTO.getCustomerId());
        address.setCustomer(mapperUtil.convert(customer, new Customer()));

        Address savedAddress = addressRepository.save(address);

        return mapperUtil.convert(savedAddress, new AddressDTO());
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) {
        Address address = mapperUtil.convert(addressDTO, new Address());

        CustomerDTO customer = customerService.findById(addressDTO.getCustomerId());
        address.setCustomer(mapperUtil.convert(customer, new Customer()));

        Address updatedAddress = addressRepository.save(address);

        return mapperUtil.convert(updatedAddress, new AddressDTO());
    }

    @Override
    public List<AddressDTO> findAllByCustomerId(Long id) {
        List<Address> addressList = addressRepository.retrieveByCustomerId(id);
        return addressList.stream().map(address -> mapperUtil.convert(address, new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> findAllByStartsWith(String pattern) {
        List<Address> addressList = addressRepository.findAllByStreetStartingWith(pattern);
        return addressList.stream().map(address -> mapperUtil.convert(address, new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> findAllByCustomerIdAndName(Long id, String name) {
        List<Address> addressList = addressRepository.findAllByCustomer_IdAndName(id, name);
        return addressList.stream().map(address -> mapperUtil.convert(address, new AddressDTO())).collect(Collectors.toList());
    }

}
