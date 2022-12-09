package com.cydeo.service.impl;

import com.cydeo.dto.CartDTO;
import com.cydeo.entity.Cart;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.CartRepository;
import com.cydeo.service.CartService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final MapperUtil mapperUtil;

    public CartServiceImpl(CartRepository cartRepository, MapperUtil mapperUtil) {
        this.cartRepository = cartRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public CartDTO findById(Long id) {
        Optional<Cart> cart = cartRepository.findById(id);
        return mapperUtil.convert(cart, new CartDTO());
    }

}
