package com.example.api_model_tests.repositories;

import com.example.api_model_tests.entities.StockEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockEntryRepository extends JpaRepository<StockEntry, UUID> {
}
