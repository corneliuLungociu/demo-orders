package com.corneliu.demoorders.model.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@ToString
@Entity
@Table(name = "ORDERS")
public class OrderEntity {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "DATE")
    private Date date;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "ORDER_ID")
    private List<OrderEntryEntity> orderEntries = new ArrayList<>();

}
