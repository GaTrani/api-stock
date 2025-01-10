package com.example.api_model_tests.repositories;

import com.example.api_model_tests.entities.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CostumerRepository extends JpaRepository<Costumer, UUID> {
}
