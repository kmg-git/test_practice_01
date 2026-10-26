package com.example.demo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class OrderRequest {

    @NotNull(message = "회원 ID는 필수입니다.")
    private Long memberId;

    @NotEmpty(message = "주문 품목은 하나 이상이여야 합니다.")
    @Valid
    private List<OrderLineRequest> lines;
}