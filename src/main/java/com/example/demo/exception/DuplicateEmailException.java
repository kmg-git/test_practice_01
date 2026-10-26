package com.example.demo.exception;

public class DuplicateEmailException extends BaseException {
    public DuplicateEmailException(ErrorCode errorCode) {
        super(errorCode);
    }
}
