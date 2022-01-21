package com.corneliu.demoorders.resources;

import com.corneliu.demoorders.model.converters.OrderConverter;
import com.corneliu.demoorders.model.dto.CreateOrderRequest;
import com.corneliu.demoorders.model.dto.Order;
import com.corneliu.demoorders.model.entities.OrderEntity;
import com.corneliu.demoorders.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.corneliu.demoorders.model.converters.OrderConverter.toDto;
import static com.corneliu.demoorders.model.converters.OrderRequestConverter.toEntity;

@RestController
@RequestMapping("/orders")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderRequest order) {
        try {

            OrderEntity createdOrder = orderService.createOrder(toEntity(order));
            return ResponseEntity.ok(toDto(createdOrder));

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(path="", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> findAllOrders() {

        List<OrderEntity> orders = orderService.findAll();

        List<Order> orderDtos = orders.stream()
                .map(OrderConverter::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(orderDtos);
    }

    @GetMapping(path = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> findById(@PathVariable(name = "orderId") long orderId) {

        Optional<OrderEntity> order = orderService.findById(orderId);

        return order.map(OrderConverter::toDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
