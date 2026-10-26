package com.example.demo.repository;

import com.example.demo.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {
    private final Map<Long, Product> store = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong();


    public Product save(String name, int price, int stock) {
        Long id = sequence.incrementAndGet();
        Product product = new Product(id, name, price, stock);
        store.put(id, product);
        return product;
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

}
