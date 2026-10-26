package com.example.demo.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // 회원
    MEMBER_NOT_FOUND("MEM-001", "회원을 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    DUPLICATE_EMAIL("MEM-002", "이미 가입된 이력이 있는 이메일 입니다.", HttpStatus.CONFLICT),
    DUPLICATE_PHONE("MEM-003", "이미 가입된 이력이 있는 핸드폰 번호 입니다.", HttpStatus.CONFLICT),

    // 결제
    PAYMENT_NOT_ENOUGH_VALUE("PAY-001", "잔액부족합니다.", HttpStatus.CONFLICT),

    // 상품
    PRODUCT_NOT_FOUND("PRD-001","상품을 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    PRODUCT_OUT_OF_STOCK("PRD-002", "상품의 재고가 부족합니다.", HttpStatus.CONFLICT),

    // 공통
    INVALID_INPUT("CMN_001", "입력값이 올바르지 않습니다", HttpStatus.BAD_REQUEST),
    BAD_REQUEST("CMN_002", "요청 형식이 올바르지 않습니다", HttpStatus.BAD_REQUEST),
    ENDPOINT_NOT_FOUND("CMN_003", "요청한 주소를 찾을 수 없습니다", HttpStatus.NOT_FOUND),
    INTERNAL_ERROR("CMN_999", "서버에 문제가 발생했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
    // 어떤 코드인지?
    //
    private final String code;
    // 어떤 메시지인지?
    private final String message;
    // 그 에러른 어떤 상태 코드로 줘야하는지?
    private final HttpStatus status;
}
