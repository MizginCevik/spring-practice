package com.cydeo.service.impl;

import com.cydeo.dto.CustomerDTO;
import com.cydeo.entity.Customer;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.CustomerRepository;
import com.cydeo.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final MapperUtil mapperUtil;

    public CustomerServiceImpl(CustomerRepository customerRepository, MapperUtil mapperUtil) {
        this.customerRepository = customerRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public CustomerDTO findById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return mapperUtil.convert(customer, new CustomerDTO());
    }

    @Override
    public List<CustomerDTO> findAll() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList.stream().map(customer -> mapperUtil.convert(customerList, new CustomerDTO())).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findByEmail(String email) {
        Customer customer = customerRepository.retrieveByCustomerEmail(email);
        return mapperUtil.convert(customer, new CustomerDTO());
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        Customer customer = customerRepository.save(mapperUtil.convert(customerDTO, new Customer()));
        return mapperUtil.convert(customer, new CustomerDTO());
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {
        Customer customer = customerRepository.save(mapperUtil.convert(customerDTO, new Customer()));
        return mapperUtil.convert(customer, new CustomerDTO());
    }

}
