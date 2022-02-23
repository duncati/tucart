package com.trackunit.cart.model;

import java.math.BigDecimal;

public interface IItem {

    Long getId();

    void setId(Long id);

    String getSku();

    void setSku(String sku);

    String getName();

    void setName(String name);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);
}
