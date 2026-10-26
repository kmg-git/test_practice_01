package com.example.demo.exception;

public abstract class BaseException extends RuntimeException {

    // 포멧을 통일시켜준것이다.
    // 에러 메시지를 사용하고 싶어 어디서? 무조건 여기서
    // 에러 메시지를 통해서 예외처리 메시지를 작성할수있어.
    // 에러 메시지를 어디서 관리하는데?

    private final ErrorCode errorCode;

    protected  BaseException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
