package com.example.api_model_tests.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@ToString
@Entity
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_uuid")
    private Supplier supplier;

    //@JsonManagedReference
    //@OneToMany //(mappedBy = "purchase", fetch = FetchType.LAZY)
    @ElementCollection
    @CollectionTable(name = "stock_entries", joinColumns = @JoinColumn(name = "purchase_uuid"))
    @JsonProperty("items")
    private List<PurchaseItem> productItems;

    private LocalDate purchaseDate;

    private double totalAmount;

    public Purchase(){}

    public Purchase(UUID uuid, Supplier supplier, List<PurchaseItem> productItems, LocalDate purchaseDate, double totalAmount) {
        this.uuid = uuid;
        this.supplier = supplier;
        this.productItems = productItems;
        this.purchaseDate = purchaseDate;
        this.totalAmount = totalAmount;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<PurchaseItem> getProductItems() {
        return productItems;
    }

    public void setProductItems(List<PurchaseItem> productItems) {
        this.productItems = productItems;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
