package com.trackunit.cart.service;

import com.trackunit.cart.exception.CartNotFoundException;
import com.trackunit.cart.exception.ItemNotFoundException;
import com.trackunit.cart.model.IItem;

import java.util.List;

public interface ShoppingCartService {
    List<IItem> getCartItems(Long cartId);
    void addItem(Long cartId, Long itemId) throws CartNotFoundException, ItemNotFoundException;
    void removeItem(Long cartId, Long itemId) throws CartNotFoundException;
}
