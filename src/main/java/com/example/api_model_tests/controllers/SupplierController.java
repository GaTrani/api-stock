package com.example.api_model_tests.controllers;

import com.example.api_model_tests.entities.Supplier;
import com.example.api_model_tests.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierRepository supplierRepository;

    @GetMapping
    public ResponseEntity<?> listAll(){
        List<Supplier> suppliers = supplierRepository.findAll();
        return ResponseEntity.ok(suppliers);
    }

    @PostMapping
    public ResponseEntity<?> createSupplier(@RequestBody Supplier supplier){
        Supplier s = new Supplier();
        s.setName(supplier.getName());
        s.setCnpj(supplier.getCnpj());
        supplierRepository.save(s);
        return ResponseEntity.ok(s);
    }
}
