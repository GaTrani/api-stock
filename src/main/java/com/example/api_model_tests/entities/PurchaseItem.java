package com.example.api_model_tests.entities;

import jakarta.persistence.*;
import lombok.ToString;

import java.math.BigDecimal;

//@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
@ToString
public class PurchaseItem {

    private Long id;

    @ManyToOne //@JoinColumn(name = "product_uuid")
    private Product product;

    private double quantity;

    private BigDecimal unitPrice;

    private BigDecimal totalPrice;

    public PurchaseItem(){}

    public PurchaseItem(Long id, Product product, double quantity, BigDecimal unitPrice, BigDecimal totalPrice) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        //this.totalPrice = unitPrice.multiply(new BigDecimal(quantity));
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
        //this.totalPrice = unitPrice.multiply(new BigDecimal(quantity));
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
