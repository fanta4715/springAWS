package com.fanta4715.book.springboot.web.dto;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트(){
        //given
        String name ="test";
        int amount=1000;
        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        //assertj : 테스트 검증 라이브러리의 검증 메소드
        //메소드 인자로 검사할 놈 받고, isEqualTo로 확인
        assertThat(dto.getName()).isEqualTo("test");
        assertThat(dto.getAmount()).isEqualTo(amount);
    }


}
