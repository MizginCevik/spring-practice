package com.cydeo.service.impl;

import com.cydeo.dto.CustomerDTO;
import com.cydeo.entity.Customer;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.CustomerRepository;
import com.cydeo.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<CustomerDTO> getCustomerList() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList.stream().map(customer -> mapperUtil.convert(customerList, new CustomerDTO())).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerListByEmail(String email) {
        Customer customer = customerRepository.retrieveByCustomerEmail(email);
        return mapperUtil.convert(customer, new CustomerDTO());
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        customerRepository.save(mapperUtil.convert(customerDTO, new Customer()));
        return customerDTO;
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        Customer customer = mapperUtil.convert(customerDTO, new Customer());
        customerRepository.save(customer);
        return customerDTO;
    }

}
