package com.example.demo.domain;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class BannedWordValidator implements ConstraintValidator<BannedWord, String> {

    private static final List<String> BANNED = List.of("짝퉁", "가짜", "불법", "마약");


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) {
            return true; // 만약에 Banned   라는 어노테이션이 붙은 필드의 값이 null 이면 어떻게 할거냐?
            // null 검사하는것 -> true 금칙어 검사는 들어가선 안되는 단어를 검사해주는거지 값이 들어왔는지 들어오지 않았는지는 책임 범위 밖입니다.
            // null 인지 아닌기 검사하는 것은 NotBlack, NotNull 어노테이션에서 수행하고 우리는 그냥 금지된 단어가 있는지 없는지만 검사할것임.
        }

        // Banned 라는 어노테이션이 붙은 필드의 값이 금칙어로 정한 BANNED 안에 들어가 있는지 없는지를 검사하는 것입니다.
        // true 면 통과
        // false면 문제 있음
        return BANNED.stream().noneMatch(value::contains);
    }
}
