package com.example.api_model_tests.entities;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.UUID;

@ToString
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private String code;

    private String name;

    private double price;

    private String description;

    public Product(){}

    public Product(UUID uuid, String code, String name, double price, String description) {
        this.uuid = uuid;
        this.code = code;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
