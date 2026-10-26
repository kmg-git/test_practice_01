package com.example.demo.domain;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // 필드에다가만 붙일수있다
@Retention(RetentionPolicy.RUNTIME) // 서버가 실행되는 동안에만 정보가 남아있게 하겠다
@Constraint(validatedBy = BannedWordValidator.class) // 실제로 동작하는 클래스를 연결
public @interface BannedWord {

    String message() default "사용할 수 없는 단어가 포함되어 있습니다";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
