package com.example.demo.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {


    @Test
    void 재고추가_성공_01(){
        //given
        Product product = new Product(1L,"키보드",3000,5);

        //when
        product.addStock(3);

        //then
        assertEquals(8,product.getStock());
    }

    @Test
    void 재고추가_성공_02(){
        //given
        Product product = new Product(1L,"키보드",3000,5);

        //when
        product.addStock(1);

        //then
        assertEquals(6,product.getStock());
    }

    @Test
    void 재고추가_실패_01(){
        //given
        Product product = new Product(1L,"키보드",3000,5);

        //when then

        assertThrows(IllegalArgumentException.class, () -> product.addStock(0));

    }


    @Test
    void 재고추가_실패_02(){
        //given
        Product product = new Product(1L,"키보드",3000,5);

        //when then

        assertThrows(IllegalArgumentException.class, () -> product.addStock(-1));

    }

    @Test
    void 재고추가_반복_성공(){
        //given
        Product product = new Product(1L,"키보드",3000,5);

        //when
        product.addStock(3);
        product.addStock(3);
        product.addStock(3);

        //then
        assertEquals(14,product.getStock());
    }

}