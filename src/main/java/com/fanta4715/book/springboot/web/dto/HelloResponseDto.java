package com.fanta4715.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    //final 변수들 초기화 되어야 하는데, 여기서는 오류 안 남
    // 이유 : @RequiredArgsConstructor
    // "final"필드가 모두 포함된 생성자 자동 생성

    // @Getter : "모든" 필드 get 메소드 생성
    private final String name;
    private final int amount;
}
