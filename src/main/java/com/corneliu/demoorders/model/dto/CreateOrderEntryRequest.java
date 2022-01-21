package com.corneliu.demoorders.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderEntryRequest {

    private long id;
    private long productId;
    private long quantity;

}
