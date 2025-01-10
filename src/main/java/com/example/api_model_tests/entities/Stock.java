package com.example.api_model_tests.entities;

import jakarta.persistence.*;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@ToString
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @ManyToOne
    private  Product product;

    private int quantity;

    private BigDecimal averageCost;

    private BigDecimal totalCost;

}
