package com.corneliu.demoorders.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntry {

    private long id;

    private Product product;
    private long quantity;

}
