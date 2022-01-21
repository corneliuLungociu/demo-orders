package com.corneliu.demoorders.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private long id;
    private Date date;

    private List<OrderEntry> entries;

}
