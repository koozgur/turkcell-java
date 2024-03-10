package com.turkcell.spring.starter.controllers;


import com.turkcell.spring.starter.entities.Orders;
import com.turkcell.spring.starter.services.abstracts.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @GetMapping
    public List<Orders> getAll(){
        return orderService.getAll();
    }
}
