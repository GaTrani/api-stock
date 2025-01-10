package com.example.api_model_tests.controllers;

import com.example.api_model_tests.entities.Costumer;
import com.example.api_model_tests.repositories.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/costumer")
public class CostumerController {

    @Autowired
    private CostumerRepository costumerRepository;

    @GetMapping
    public ResponseEntity<?> listAll(){
        List<Costumer> costumerList = costumerRepository.findAll();
        return ResponseEntity.ok(costumerList);
    }

    @PostMapping
    public ResponseEntity<?> createCostumer(@RequestBody Costumer costumer){
        Costumer c = new Costumer();
        c.setName(costumer.getName());
        costumerRepository.save(c);
        return ResponseEntity.ok(c);
    }
}
