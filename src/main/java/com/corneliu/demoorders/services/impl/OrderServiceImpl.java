package com.corneliu.demoorders.services.impl;

import com.corneliu.demoorders.model.entities.OrderEntity;
import com.corneliu.demoorders.repositories.OrderRepository;
import com.corneliu.demoorders.repositories.ProductRepository;
import com.corneliu.demoorders.services.OrderService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public OrderEntity createOrder(OrderEntity order) {
        log.info("Creating new order: " + order);
        Preconditions.checkArgument(!emptyOrder(order), "Order must have at least 1 product.");
        Preconditions.checkArgument(productsExist(order), "Order must have at least 1 product.");

        return orderRepository.save(order);
    }

    @Override
    public Optional<OrderEntity> findById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<OrderEntity> findAll() {
        return orderRepository.findAll();
    }

    private boolean emptyOrder(OrderEntity order) {
        return order.getOrderEntries().isEmpty() || allLinesAreEmpty(order);
    }

    private boolean allLinesAreEmpty(OrderEntity order) {
        return order.getOrderEntries()
                .stream()
                .allMatch(line -> line.getQuantity() == 0);
    }

    private boolean productsExist(OrderEntity order) {
        return order.getOrderEntries().stream()
                .allMatch(entry -> productRepository.existsById(entry.getProduct().getId()));
    }
}
