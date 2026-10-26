package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderLineRequest {

    @NotNull(message = "상품 ID는 필수입니다.")
    private Long productId;
    @Min(value = 1, message = "수량은 최소 1개 이상이여야 합니다.")
    private int quantity;
}
