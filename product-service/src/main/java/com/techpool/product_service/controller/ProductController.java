package com.techpool.product_service.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techpool.product_service.model.Product;

@RestController
@RequestMapping("/api")
public class ProductController {

    // Simple in-memory product list
    private List<Product> products = Arrays.asList(
        new Product(1L, "Laptop", "High-performance laptop", 1299.99),
        new Product(2L, "Smartphone", "Latest smartphone model", 899.99),
        new Product(3L, "Headphones", "Noise-cancelling headphones", 249.99)
    );

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return products;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
}
