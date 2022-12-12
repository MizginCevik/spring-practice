package com.cydeo.service.impl;

import com.cydeo.dto.CartDTO;
import com.cydeo.dto.CustomerDTO;
import com.cydeo.dto.OrderDTO;
import com.cydeo.dto.PaymentDTO;
import com.cydeo.entity.Cart;
import com.cydeo.entity.Customer;
import com.cydeo.entity.Order;
import com.cydeo.entity.Payment;
import com.cydeo.enums.PaymentMethod;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.OrderRepository;
import com.cydeo.service.CartService;
import com.cydeo.service.CustomerService;
import com.cydeo.service.OrderService;
import com.cydeo.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final MapperUtil mapperUtil;
    private final CustomerService customerService;
    private final CartService cartService;
    private final PaymentService paymentService;

    public OrderServiceImpl(OrderRepository orderRepository, MapperUtil mapperUtil, CustomerService customerService, CartService cartService, PaymentService paymentService) {
        this.orderRepository = orderRepository;
        this.mapperUtil = mapperUtil;
        this.customerService = customerService;
        this.cartService = cartService;
        this.paymentService = paymentService;
    }

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        Order order = mapperUtil.convert(orderDTO, new Order());

        CustomerDTO customer = customerService.findById(orderDTO.getCustomerId());
        order.setCustomer(mapperUtil.convert(customer, new Customer()));

        PaymentDTO payment = paymentService.findById(orderDTO.getPaymentId());
        order.setPayment(mapperUtil.convert(payment, new Payment()));

        CartDTO cart = cartService.findById(orderDTO.getCartId());
        order.setCart(mapperUtil.convert(cart, new Cart()));

        Order savedOrder = orderRepository.save(order);

        return mapperUtil.convert(savedOrder, new OrderDTO());
    }

    @Override
    public OrderDTO update(OrderDTO orderDTO) {
        Order order = mapperUtil.convert(orderDTO, new Order());

        CustomerDTO customer = customerService.findById(orderDTO.getCustomerId());
        order.setCustomer(mapperUtil.convert(customer, new Customer()));

        PaymentDTO payment = paymentService.findById(orderDTO.getPaymentId());
        order.setPayment(mapperUtil.convert(payment, new Payment()));

        CartDTO cart = cartService.findById(orderDTO.getCartId());
        order.setCart(mapperUtil.convert(cart, new Cart()));

        Order updatedOrder = orderRepository.save(order);

        return mapperUtil.convert(updatedOrder, new OrderDTO());
    }

    @Override
    public List<OrderDTO> findAll() {
        List<Order> orderList = orderRepository.findAll();
        return orderList.stream().map(order -> mapperUtil.convert(order, new OrderDTO())).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> findByEmail(String email) {
        List<Order> orderList = orderRepository.findAllByCustomer_Email(email);
        return orderList.stream().map(order -> mapperUtil.convert(order, new OrderDTO())).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> findByPaymentMethod(PaymentMethod paymentMethod) {
        List<Order> orderList = orderRepository.findAllByPayment_PaymentMethod(paymentMethod);
        return orderList.stream().map(order -> mapperUtil.convert(order, new OrderDTO())).collect(Collectors.toList());
    }

}
