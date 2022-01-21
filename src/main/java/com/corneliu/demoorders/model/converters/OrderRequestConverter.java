package com.corneliu.demoorders.model.converters;

import com.corneliu.demoorders.model.dto.CreateOrderEntryRequest;
import com.corneliu.demoorders.model.dto.CreateOrderRequest;
import com.corneliu.demoorders.model.entities.OrderEntity;
import com.corneliu.demoorders.model.entities.OrderEntryEntity;
import com.corneliu.demoorders.model.entities.ProductEntity;

import java.util.stream.Collectors;

public class OrderRequestConverter {

    public static OrderEntity toEntity(CreateOrderRequest dto) {
        if (dto == null) {
            return null;
        }

        OrderEntity entity = new OrderEntity();
        entity.setId(dto.getOrderId());
        entity.setDate(dto.getDate());
        entity.setOrderEntries(dto.getEntries().stream()
                .map(OrderRequestConverter::toEntity)
                .collect(Collectors.toList())
        );

        return entity;
    }

    private static OrderEntryEntity toEntity(CreateOrderEntryRequest dto) {
        if (dto == null) {
            return null;
        }

        OrderEntryEntity entity = new OrderEntryEntity();
        entity.setId(dto.getId());
        entity.setQuantity(dto.getQuantity());

        ProductEntity product = new ProductEntity();
        product.setId(dto.getProductId());

        entity.setProduct(product);

        return entity;
    }
}
