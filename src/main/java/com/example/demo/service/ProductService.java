package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.dto.ProductRequest;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public Product save(ProductRequest request) {
        return productRepository.save(
                request.getName(),
                request.getPrice(),
                request.getStock()
        );
    }
}
