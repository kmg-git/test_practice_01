package com.example.demo.domain;

import com.example.demo.exception.ErrorCode;
import com.example.demo.exception.OutOfStockException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {

    private Long id;
    private String name;
    private int price;
    private int stock;

    // 재고를 감소 시키는 기능
    public void removeStock(int quantity) {
        // 무조건 뚤려요!
        // 10개만 가지고 있는데 20개가 주문이 들어와도 뚤힙니다.
        if(this.stock < quantity) {
            throw new OutOfStockException(ErrorCode.PRODUCT_OUT_OF_STOCK);
        }
        this.stock -= quantity;
    }
}