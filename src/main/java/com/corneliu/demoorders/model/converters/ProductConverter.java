package com.corneliu.demoorders.model.converters;

import com.corneliu.demoorders.model.dto.Product;
import com.corneliu.demoorders.model.entities.ProductEntity;

public class ProductConverter {

    private ProductConverter() {
        throw new UnsupportedOperationException("Utility class should not be instantiated");
    }

    public static ProductEntity toEntity(Product dto) {
        if (dto == null) {
            return null;
        }

        ProductEntity entity = new ProductEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        return entity;
    }

    public static Product toDto(ProductEntity entity) {
        if (entity == null) {
            return null;
        }

        return new Product(entity.getId(), entity.getName());
    }

}
