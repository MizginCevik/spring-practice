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
    //if you do something static, it means it will be created right away when the application starts.
    //CART is something we want it to be there when the application starts,
    //and also since we will be using the same CART object in everywhere in our code, we can make it static
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

        Product product = productService.findProductById(productId);

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItem.setTotalAmount(product.getPrice().multiply(BigDecimal.valueOf(quantity)));

        if (CART.getCartItemList().stream().noneMatch(item -> item.getProduct().getId().toString().equals(cartItem.getProduct().getId().toString()))){
            CART.getCartItemList().add(cartItem);
            CART.setCartTotalAmount(CART.getCartTotalAmount().add(cartItem.getTotalAmount()));
        }

        return CART;
    }

    @Override
    public boolean deleteFromCart(UUID productId){
        //todo delete product object from cart using stream

        CartItem cartItemToDelete = CART.getCartItemList().stream()
                .filter(p -> p.getProduct().getId().toString().equals(productId.toString()))
                .findFirst().orElseThrow();

        CART.setCartTotalAmount(CART.getCartTotalAmount().subtract(cartItemToDelete.getTotalAmount()));

        return CART.getCartItemList().remove(cartItemToDelete);
    }
}
