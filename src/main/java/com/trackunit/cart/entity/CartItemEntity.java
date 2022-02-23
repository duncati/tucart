package com.trackunit.cart.entity;

import javax.persistence.*;

@Entity
@Table(name="cart_item")
public class CartItemEntity {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="cartid")
    private Long cartId;

    @Column(name="itemid")
    private Long itemId;

    @Column(name="quantity")
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId=cartId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId=itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity=quantity;
    }

    public void incrementQuantity() {
        this.quantity++;
    }

    public void decrementQuantity() {
        this.quantity--;
    }
}
