package com.cydeo.service;

import com.cydeo.dto.OrderDTO;
import com.cydeo.enums.PaymentMethod;

import java.util.List;

public interface OrderService {

    OrderDTO create(OrderDTO orderDTO);
    OrderDTO update(OrderDTO orderDTO);
    List<OrderDTO> findAll();
    List<OrderDTO> findByEmail(String email);
    List<OrderDTO> findByPaymentMethod(PaymentMethod paymentMethod);

}
