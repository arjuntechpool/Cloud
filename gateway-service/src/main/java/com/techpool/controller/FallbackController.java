package com.techpool.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/product")
    public String productServiceFallback() {
        return "Product Service is currently unavailable. Please try again later.";
    }

    @GetMapping("/order")
    public String orderServiceFallback() {
        return "Order Service is currently unavailable. Please try again later.";
    }
}