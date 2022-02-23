package com.trackunit.cart.model;

import java.util.List;

public interface ICart {
    Long getId();

    void setId(Long id);

    List<IItem> getItems();

    void setItems(List<IItem> items);
}