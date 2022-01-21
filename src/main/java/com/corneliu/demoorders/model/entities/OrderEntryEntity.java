package com.corneliu.demoorders.model.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OrderEntryEntity {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity product;

    @Column(name = "QUANTITY")
    private long quantity;

}
