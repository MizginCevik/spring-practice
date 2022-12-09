package com.cydeo.service.impl;

import com.cydeo.dto.AddressDTO;
import com.cydeo.entity.Address;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.AddressRepository;
import com.cydeo.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final MapperUtil mapperUtil;

    public AddressServiceImpl(AddressRepository addressRepository, MapperUtil mapperUtil) {
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<AddressDTO> findAll() {
        List<Address> addressList = addressRepository.findAll();
        return addressList.stream().map(address -> mapperUtil.convert(address, new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public AddressDTO create(AddressDTO addressDTO) {
        addressRepository.save(mapperUtil.convert(addressDTO, new Address()));
        return addressDTO;
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) {
        Address address = mapperUtil.convert(addressDTO, new Address());
        addressRepository.save(address);
        return addressDTO;
    }

    @Override
    public List<AddressDTO> findByCustomerId(Long id) {
        List<Address> addressList = addressRepository.retrieveByCustomerId(id);
        return addressList.stream().map(address -> mapperUtil.convert(address, new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> findByStartsWithAddress(String pattern) {
        List<Address> addressList = addressRepository.findAllByStreetStartingWith(pattern);
        return addressList.stream().map(address -> mapperUtil.convert(address, new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> findByCustomerAndName(Long id, String name) {
        List<Address> addressList = addressRepository.findAllByCustomer_IdAndName(id, name);
        return addressList.stream().map(address -> mapperUtil.convert(address, new AddressDTO())).collect(Collectors.toList());
    }

}
