package com.fanta4715.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // Entity가 아래 Date들도 Col로 인식하게 해줌
@EntityListeners(AuditingEntityListener.class) //Auditing기능 포함
public abstract class BaseTimeEntity {
    @CreatedDate //생성시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate //조회시간 자동 저장
    private LocalDateTime modifiedDate;
}
