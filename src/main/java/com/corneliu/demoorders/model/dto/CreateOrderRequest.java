package com.corneliu.demoorders.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {

    private long orderId;
    private Date date;

    private List<CreateOrderEntryRequest> entries = new ArrayList<>();

}
