package com.cydeo.spring05thymeleaf.service.impl;

import com.cydeo.spring05thymeleaf.model.Cart;
import com.cydeo.spring05thymeleaf.model.CartItem;
import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.service.CartService;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
    public static Cart CART = new Cart(BigDecimal.ZERO,new ArrayList<>());
    private final ProductService productService;

    public CartServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Cart addToCart(UUID productId, Integer quantity){
        //todo retrieve product from repository method
        //todo initialise cart item
        //todo calculate cart total amount
        //todo add to cart

        CartItem cartItem = new CartItem();
        cartItem.setProduct(productService.findProductById(productId));
        cartItem.setQuantity(quantity);
        cartItem.setTotalAmount(productService.findProductById(productId).getPrice().multiply(BigDecimal.valueOf(quantity)));

        if (CART.getCartItemList().stream().noneMatch(item -> item.getProduct().getId().toString().equals(cartItem.getProduct().getId().toString()))){
            CART.getCartItemList().add(cartItem);
            CART.setCartTotalAmount(CART.getCartTotalAmount().add(cartItem.getTotalAmount()));
        }

        return CART;
    }

    @Override
    public boolean deleteFromCart(UUID productId){
        //todo delete product object from cart using stream

        CartItem cartItemToDelete = CART.getCartItemList().stream().filter(p -> p.getProduct().getId().toString().equals(productId.toString())).findFirst().orElseThrow();
        CART.getCartItemList().remove(cartItemToDelete);

        CART.setCartTotalAmount(CART.getCartTotalAmount().subtract(cartItemToDelete.getTotalAmount()));

        return true;
    }
}
