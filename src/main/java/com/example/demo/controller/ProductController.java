package com.example.demo.controller;

import com.example.demo.domain.OnCreate;
import com.example.demo.domain.OnUpdate;
import com.example.demo.domain.Product;
import com.example.demo.dto.ProductRequest;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

// controller/OrderController.java
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product createProducts(@Valid @RequestBody ProductRequest request) {
        return productService.save(request);
    }
}