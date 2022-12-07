package com.cydeo.service;

import com.cydeo.dto.OrderDTO;
import com.cydeo.enums.PaymentMethod;

import java.util.List;

public interface OrderService {

    OrderDTO createOrder(OrderDTO orderDTO);
    OrderDTO updateOrder(OrderDTO orderDTO);
    List<OrderDTO> getAddressList();
    List<OrderDTO> getOrderListByEmail(String email);
    List<OrderDTO> getOrderListByPaymentMethod(PaymentMethod paymentMethod);

}
