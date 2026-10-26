package com.example.demo.exception;

import com.example.demo.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler {

    // 공동 응답객체
    // BaseException 특징 자바에서 디폴트로 만들어준 예외를 제외한
    // 사용자가 직접 커스텀한 예외들의 묶음
    // 우리가 커스텀으로 등록한 예외만 걸리도록 했는데
    // 우리 백퍼센트 안전하게 모든 부분에서 안전성을다 체크했으면 모르는데
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handlesBase(BaseException exception) {
        ErrorCode errorCode = exception.getErrorCode();
        log.warn("요청이 실패가 되었습니다. code ={}, message={}",errorCode.getCode(), errorCode.getMessage());

        return ResponseEntity.status(errorCode.getStatus())
                .body(ErrorResponse.of(errorCode));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException e) {

        List<ErrorResponse.FieldError> errors = e.getBindingResult().getFieldErrors().stream()
                .map(fe -> new ErrorResponse.FieldError(fe.getField(), fe.getDefaultMessage()))
                .toList();

        log.warn("입력값 검증 실패 {}", errors.stream()
                .map(fe -> fe.getField() + "=" + fe.getMessage())
                .toList());

        return ResponseEntity.status(ErrorCode.INVALID_INPUT.getStatus())
                .body(ErrorResponse.of(ErrorCode.INVALID_INPUT, errors));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnexpected(Exception e) {

        log.error("우리가 예상하지 못한 예외가 발생했습니다.");
        // error 에 필터를 걸고 데이터가 들어오면 slack 이나 discord 지금 너가 관리하고 있는 모니터링 대시보드에 error라는 레벨의 로그가 찍혔어

        // 고객이 주문 안되요! 라고 민원이 들어와요!
        // 고객센터에서 개발자에게 연락이 옵니다.
        // 어떤 고객이 이런 행위가 안된다고 합니다.
        // 고객 아이디를 기준으로 검색해요!
        // 그리고 어떤 행위를 할려고했는지 등등 조사합니다 .

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.of(ErrorCode.INTERNAL_ERROR));
    }

    // 잔액 부족이란느 에러가 있다고 해보겠습니다.

}

// 처음에는 이 구조가 익숙하지 않을것입니다.
// 복잡할거에요!
// 많이 복습 많이 봐보세요!
