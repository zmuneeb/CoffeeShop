package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository productRepository;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/buy/{productName}")
    public ResponseEntity<Map<String, Object>> buyProduct(@PathVariable String productName) {
        logger.info("Product name provided in request: " + productName);

        List<Product> allProducts = productRepository.findAll();
        logger.info("All product names in repository: " + allProducts.stream()
                .map(Product::getName)
                .collect(Collectors.toList()));

        Optional<Product> productOpt = productRepository.findByName(productName);
        if (productOpt.isPresent()) {
            logger.info("Product found: " + productOpt.get().getName());
        } else {
            logger.info("Product not found");
        }
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            if (product.getInv() > 0) {
                product.setInv(product.getInv() - 1);
                productRepository.save(product);
                return ResponseEntity.ok(Collections.singletonMap("success", true));
            } else {
                return ResponseEntity.ok(Collections.singletonMap("message", "Product is out of stock"));
            }
        } else {
            return ResponseEntity.ok(Collections.singletonMap("message", "Product not found"));
        }
    }
}