package com.example.demo.exception;

public class MemberNotFoundException extends BaseException {
    public MemberNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
