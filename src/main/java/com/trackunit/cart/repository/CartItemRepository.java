package com.trackunit.cart.repository;

import com.trackunit.cart.entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItemEntity, Long> {
    @Query(value="select * from cart_item where cartid=?1")
    List<CartItemEntity> findAllCartItemsInCart(Long cartId);

    @Query(value="select * from cart_item where cartid=?1 and itemid=?2")
    CartItemEntity findThisCartItem(Long cartId, Long itemId);
}
