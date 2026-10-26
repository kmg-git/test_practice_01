package com.example.demo.dto;

import com.example.demo.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private String code;
    private String message;
    private List<FieldError> errors;

    public static ErrorResponse of(ErrorCode errorCode) {
        return new ErrorResponse(errorCode.getCode(), errorCode.getMessage(), null);
    }

    public static ErrorResponse of(ErrorCode errorCode, List<FieldError> errors) {
        return new ErrorResponse(errorCode.getCode(), errorCode.getMessage(), errors);
    }

    @Getter
    @AllArgsConstructor
    public static class FieldError {

        private String field;
        private String message;
    }
}