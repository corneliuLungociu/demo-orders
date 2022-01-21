package com.corneliu.demoorders.model.converters;

import com.corneliu.demoorders.model.dto.Order;
import com.corneliu.demoorders.model.dto.OrderEntry;
import com.corneliu.demoorders.model.entities.OrderEntity;

import java.util.List;
import java.util.stream.Collectors;

public class OrderConverter {

    private OrderConverter() {
        throw new UnsupportedOperationException("Utility class should not be instantiated");
    }

    public static OrderEntity toEntity(Order dto) {
        if (dto == null) {
            return null;
        }

        OrderEntity entity = new OrderEntity();
        entity.setDate(dto.getDate());
        entity.setId(dto.getId());
        entity.setOrderEntries(dto.getEntries().stream()
                .map(OrderEntryConverter::toEntity)
                .collect(Collectors.toList())
        );

        return entity;
    }

    public static Order toDto(OrderEntity entity) {
        if (entity == null) {
            return null;
        }

        List<OrderEntry> entriesDto = entity.getOrderEntries().stream()
                .map(OrderEntryConverter::toDto)
                .collect(Collectors.toList());

        return new Order(entity.getId(), entity.getDate(), entriesDto);
    }

}
