package com.turkcell.spring.starter.services.concretes;

import com.turkcell.spring.starter.entities.Orders;
import com.turkcell.spring.starter.repositories.abstracts.OrderRepository;
import com.turkcell.spring.starter.services.abstracts.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderSeriveImpl implements OrderService {
    private final OrderRepository orderRepository;
    @Override
    public List<Orders> getAll() {
        return orderRepository.findAll();
    }
}
