package com.example.demo.dto;

import com.example.demo.domain.BannedWord;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
// 생성, 수정, 삭제, 조회
public class ProductRequest {

    @BannedWord
    @NotBlank(message = "상품명은 필수입니다.")
    private String name;
    @Positive(message = "가격은 0보다 커야 합니다")
    private int price;
    @PositiveOrZero(message = "재고는 0 이상이어야 합니다")
    private int stock;


    // 외부의 값을 검증해주고 있는거잖용/
    // validate를 어디까지 해줘야 하는것인지?


    // 스프링 부트 3계층에 대해서 우리 했습니다.
    // controller
    // service
    // repository

    // 3 계층에는 본인이 담당한 책임과 역할의 범위가 다르다!


    // controller의 역할은 외부에서 들어온 더러운 값을 서비스에서 바로 사용할수있게금
    // 한번 걸러주는 역할

    // service는 본격적인 외부에서 들어온 깔끔한 값을 가지고 본격적으로 비즈니스 로직이 수행되는 곳

    // repository service에서 저장된 값을 불러오거나 새로운 값을 저장할 때 사용한다
}
