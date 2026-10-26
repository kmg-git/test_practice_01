package com.example.demo.exception;

public class ProductNotFoundException extends BaseException {
    public ProductNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
