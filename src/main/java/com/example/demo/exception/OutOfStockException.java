package com.example.demo.exception;

public class OutOfStockException extends BaseException {
    public OutOfStockException(ErrorCode errorCode) {
        super(errorCode);
    }
}
