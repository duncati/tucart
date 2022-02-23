package com.trackunit.cart.controller;

import com.trackunit.cart.model.IItem;
import com.trackunit.cart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingCartController {

    @Autowired
    ShoppingCartService service;

    @GetMapping("/cart/{cartid}")
    List<IItem> getShoppingCartItems(@PathVariable Long cartId) {
        return service.getCartItems(cartId);
    }

    @PutMapping("/cart/{cartid}")
    void addShoppingCartItem(@PathVariable Long cartId, @RequestParam Long itemId) {
        service.addItem(cartId, itemId);
    }

    @DeleteMapping("/cart/{cartid}")
    void removeShoppingCartItem(@PathVariable Long cartId, @RequestParam Long itemId) {
        service.removeItem(cartId, itemId);
    }
}