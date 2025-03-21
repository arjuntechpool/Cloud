package com.techpool.order_service.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techpool.order_service.model.Order;
import com.techpool.order_service.model.OrderItem;

@RestController
@RequestMapping("/api")
public class OrderController {

    // Simple in-memory order list
    private List<Order> orders = Arrays.asList(
        new Order(1L, 101L, LocalDateTime.now().minusDays(1), "COMPLETED",
                Arrays.asList(new OrderItem(1L, 1, 1299.99), new OrderItem(3L, 1, 249.99))),
        new Order(2L, 102L, LocalDateTime.now().minusHours(5), "PROCESSING",
                Arrays.asList(new OrderItem(2L, 2, 899.99)))
    );

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orders;
    }

    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orders.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }
}
