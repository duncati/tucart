package com.trackunit.cart.entity;

import com.trackunit.cart.model.IItem;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="item")
public class ItemEntity implements IItem {

    @Id
    @GeneratedValue
    @JoinColumn(name="id", nullable=false)
    private Long id;

    @Column(name="sku", length=30, nullable=false)
    private String sku;

    @Column(name="name", length=100, nullable=false)
    private String name;

    @Column(name="price", nullable=false)
    private BigDecimal price;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id=id;
    }

    @Override
    public String getSku() {
        return sku;
    }

    @Override
    public void setSku(String sku) {
        this.sku=sku;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price=price;
    }
}