package com.example.api_model_tests.entities;

import jakarta.persistence.*;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@ToString
@Table(name = "stock_entries")
@Entity
public class StockEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @ManyToOne
    private Purchase purchase;

    //@JoinColumn(name = "product_uuid", nullable = false)
    @ManyToOne
    private Product product;

    private double quantity;

    private BigDecimal entryPrice;

    private LocalDate entryDate;

    public StockEntry(){}

    public StockEntry(UUID uuid, Product product, double quantity, BigDecimal entryPrice, LocalDate entryDate) {
        this.uuid = uuid;
        this.product = product;
        this.quantity = quantity;
        this.entryPrice = entryPrice;
        this.entryDate = entryDate;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(BigDecimal entryPrice) {
        this.entryPrice = entryPrice;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }
}
