package com.example.api_model_tests.controllers;

import com.example.api_model_tests.entities.Product;
import com.example.api_model_tests.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<?> listAll(){
        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        Product p = new Product();
        p.setName(product.getName());
        p.setCode(product.getCode());
        p.setPrice(product.getPrice());
        p.setDescription(product.getDescription());
        productRepository.save(p);
        return ResponseEntity.ok(p);
    }

}
