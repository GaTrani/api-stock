package com.example.api_model_tests.controllers;


import com.example.api_model_tests.entities.*;
import com.example.api_model_tests.repositories.PurchaseRepository;
import com.example.api_model_tests.repositories.StockEntryRepository;
import com.example.api_model_tests.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private StockEntryRepository stockEntryRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @GetMapping
    public ResponseEntity<?> listAll(){
        List<Purchase> purchases = purchaseRepository.findAll();
        return ResponseEntity.ok(purchases);
    }

    @PostMapping
    public ResponseEntity<?> createPurchase(@RequestBody Purchase request){

        Supplier supplier = supplierRepository.findById(request.getSupplier().getUuid())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        // Cria a nova Purchase e associa o Supplier carregado
        Purchase  purchase = new Purchase();
        purchase.setSupplier(supplier);
        //purchase.setSupplier(request.getSupplier());
        purchase.setPurchaseDate(LocalDate.now());
        purchase.setTotalAmount(request.getTotalAmount());
        Purchase purchaseSave = purchaseRepository.save(purchase);

        List<PurchaseItem> items = request.getProductItems();
        System.out.println("\n\n items: " + items);
        if (items == null){
            return null;
        }else {
            for (PurchaseItem item : items) {
                StockEntry stockEntry = new StockEntry();
                stockEntry.setPurchase(purchaseSave);
                stockEntry.setProduct(item.getProduct());
                stockEntry.setQuantity(item.getQuantity());
                stockEntry.setEntryPrice(item.getUnitPrice());
                stockEntryRepository.save(stockEntry);
            }
        }

        Purchase fullPurchase = purchaseRepository.findById(purchaseSave.getUuid())
                .orElseThrow(() -> new RuntimeException("Purchase not found"));
        return ResponseEntity.ok(fullPurchase);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<?> getPurchase(@PathVariable String uuid){
        UUID n = UUID.fromString(uuid);
        Optional<Purchase> purchase = purchaseRepository.findById(n);
        return ResponseEntity.ok(purchase);
    }
}
