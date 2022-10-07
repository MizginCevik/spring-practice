package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.service.CartService;
import com.cydeo.spring05thymeleaf.service.impl.CartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public String viewCart(Model model){
        model.addAttribute("cartItemList", CartServiceImpl.CART.getCartItemList());
        model.addAttribute("cartAmount", CartServiceImpl.CART.getCartTotalAmount());
        return "cart/show-cart";
    }

    @GetMapping("/addToCart/{id}/{quantity}")
    public String addToCart(@PathVariable UUID id, @PathVariable Integer quantity){

        cartService.addToCart(id,quantity);

        return "redirect:/cart";
    }

    @GetMapping("/delete/{productId}")
    public String delete(@PathVariable UUID productId){

        cartService.deleteFromCart(productId);

        return "redirect:/cart";
    }

}
