package com.cydeo.controller;

import com.cydeo.dto.OrderDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.enums.PaymentMethod;
import com.cydeo.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createOrder(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(new ResponseWrapper("Order is created.", orderService.createOrder(orderDTO), HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateOrder(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(new ResponseWrapper("Order is updated.", orderService.updateOrder(orderDTO), HttpStatus.OK));
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAddressList() {
        return ResponseEntity.ok(new ResponseWrapper("Order List is retrieved.", orderService.getAddressList(), HttpStatus.OK));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ResponseWrapper> getOrderListByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(new ResponseWrapper("Order is retrieved by using email.", orderService.getOrderListByEmail(email), HttpStatus.OK));
    }

    @GetMapping("/paymentMethod/{paymentMethod}")
    public ResponseEntity<ResponseWrapper> getOrderListByPaymentMethod(@PathVariable("paymentMethod") PaymentMethod paymentMethod) {
        return ResponseEntity.ok(new ResponseWrapper("Order is retrieved by using payment method.", orderService.getOrderListByPaymentMethod(paymentMethod), HttpStatus.OK));
    }

}
