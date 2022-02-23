package com.trackunit.cart.service;

import com.trackunit.cart.entity.CartItemEntity;
import com.trackunit.cart.exception.CartNotFoundException;
import com.trackunit.cart.exception.ItemNotFoundException;
import com.trackunit.cart.model.IItem;
import com.trackunit.cart.repository.CartItemRepository;
import com.trackunit.cart.repository.CartRepository;
import com.trackunit.cart.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public List<IItem> getCartItems(Long cartId) {
        List<CartItemEntity> cartItems=cartItemRepository.findAllCartItemsInCart(cartId);
        // this is less than ideal but time is up
        List<IItem> items=new ArrayList<>();
        for (CartItemEntity cartItem: cartItems) {
            items.add(itemRepository.getById(cartItem.getItemId()));
        }
        return items;
    }

    @Override
    public void addItem(Long cartId, Long itemId) throws CartNotFoundException, ItemNotFoundException {
        validateCart(cartId);
        validateItem(itemId);
        CartItemEntity cartItem=cartItemRepository.findThisCartItem(cartId, itemId);
        cartItem.incrementQuantity();
        cartItemRepository.save(cartItem);
    }

    @Override
    public void removeItem(Long cartId, Long itemId) throws CartNotFoundException {
        validateCart(cartId);
        validateItem(itemId);
        CartItemEntity cartItem=cartItemRepository.findThisCartItem(cartId, itemId);
        cartItem.decrementQuantity();
        if (cartItem.getQuantity()<=0) {
            cartItemRepository.delete(cartItem);
        }
        cartItemRepository.save(cartItem);
    }

    private void validateCart(Long cartId) throws CartNotFoundException {
        if (!cartRepository.existsById(cartId)) {
            throw new CartNotFoundException("No cart found for id "+cartId);
        }
    }

    private void validateItem(Long itemId) throws ItemNotFoundException {
        if (!itemRepository.existsById(itemId)) {
            throw new ItemNotFoundException("No item found for id "+itemId);
        }
    }
}