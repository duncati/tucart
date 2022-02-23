package com.trackunit.cart.entity;

import com.trackunit.cart.model.ICart;
import com.trackunit.cart.model.IItem;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="cart")
public class CartEntity implements ICart {

    @Id
    @GeneratedValue
    @Column(name="id", updatable=false, nullable=false)
    private Long id;

    @OneToMany(mappedBy="cart")
    @JoinTable(name="cart_item", joinColumns={@JoinColumn(name="cartid")})
    private List<IItem> items;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id=id;
    }

    @Override
    public List<IItem> getItems() {
        return items;
    }

    @Override
    public void setItems(List<IItem> items) {
        this.items=items;
    }
}