package com.turkcell.spring.starter.repositories.abstracts;

import com.turkcell.spring.starter.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Integer> {
}
