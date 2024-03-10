package com.turkcell.spring.starter.services.abstracts;

import com.turkcell.spring.starter.entities.Orders;

import java.util.List;

public interface OrderService {
    List<Orders> getAll();
}
