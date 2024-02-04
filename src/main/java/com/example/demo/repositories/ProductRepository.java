package com.example.demo.repositories;

import com.example.demo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Optional<Product> findByName(String name);
    List<Product> findByNameContaining(String keyword);
    }
