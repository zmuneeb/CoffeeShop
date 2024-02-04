package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.domain.Product;

import java.util.Optional;

@Controller
public class ProductPurchaseController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/buyProduct")
    public String buyProduct(@RequestParam("productId") Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (!optionalProduct.isPresent()) {
            return "redirect:/purchaseError";
        }

        Product product = optionalProduct.get();
        if (product.getInv() <= 0) {
            return "redirect:/purchaseError";
        }

        product.setInv(product.getInv() - 1);
        productRepository.save(product);

        return "redirect:/purchaseSuccess";
    }
}