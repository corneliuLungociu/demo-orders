package com.corneliu.demoorders.services;

import com.corneliu.demoorders.model.entities.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    OrderEntity createOrder(OrderEntity order);

    Optional<OrderEntity> findById(long id);

    List<OrderEntity> findAll();
}
