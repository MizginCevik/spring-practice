package com.cydeo.service.impl;

import com.cydeo.dto.OrderDTO;
import com.cydeo.entity.Order;
import com.cydeo.enums.PaymentMethod;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.OrderRepository;
import com.cydeo.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final MapperUtil mapperUtil;

    public OrderServiceImpl(OrderRepository orderRepository, MapperUtil mapperUtil) {
        this.orderRepository = orderRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        orderRepository.save(mapperUtil.convert(orderDTO, new Order()));
        return orderDTO;
    }

    @Override
    public OrderDTO updateOrder(OrderDTO orderDTO) {
        Order order = mapperUtil.convert(orderDTO, new Order());
        orderRepository.save(order);
        return orderDTO;
    }

    @Override
    public List<OrderDTO> getAddressList() {
        List<Order> orderList = orderRepository.findAll();
        return orderList.stream().map(order -> mapperUtil.convert(order, new OrderDTO())).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrderListByEmail(String email) {
        List<Order> orderList = orderRepository.findAllByCustomer_Email(email);
        return orderList.stream().map(order -> mapperUtil.convert(order, new OrderDTO())).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrderListByPaymentMethod(PaymentMethod paymentMethod) {
        List<Order> orderList = orderRepository.findAllByPayment_PaymentMethod(paymentMethod);
        return orderList.stream().map(order -> mapperUtil.convert(order, new OrderDTO())).collect(Collectors.toList());
    }

}
