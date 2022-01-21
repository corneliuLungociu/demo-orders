package com.corneliu.demoorders.model.converters;

import com.corneliu.demoorders.model.dto.OrderEntry;
import com.corneliu.demoorders.model.entities.OrderEntryEntity;

public class OrderEntryConverter {

    private OrderEntryConverter() {
        throw new UnsupportedOperationException("Utility class should not be instantiated");
    }

    public static OrderEntryEntity toEntity(OrderEntry dto) {
        if (dto == null) {
            return null;
        }

        OrderEntryEntity entity = new OrderEntryEntity();
        entity.setId(dto.getId());
        entity.setProduct(ProductConverter.toEntity(dto.getProduct()));
        entity.setQuantity(dto.getQuantity());

        return entity;
    }

    public static OrderEntry toDto(OrderEntryEntity entity) {
        if (entity == null) {
            return null;
        }

        return new OrderEntry(entity.getId(), ProductConverter.toDto(entity.getProduct()), entity.getQuantity());
    }

}
