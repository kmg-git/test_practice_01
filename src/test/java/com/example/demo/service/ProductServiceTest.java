package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    void 상품의_재고를_늘린다_성공(){
        //given
        Product product = new Product(1L,"키보드",3000,5);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        //when
        int q = productService.restock(1L,3).getStock();


        //then
        assertEquals(8,q);

    }

    @Test
    void 상품의_재고를_늘린다_실패_없는_제품을_시도(){
        //given
        //Product product = new Product(1L,"키보드",3000,5);
        //when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        //when then
        assertThrows(NoSuchElementException.class,
                () -> productService.restock(0L,3
        ));


    }



}