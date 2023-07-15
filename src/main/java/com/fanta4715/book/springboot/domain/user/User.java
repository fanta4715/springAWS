package com.fanta4715.book.springboot.domain.user;

import com.fanta4715.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
//    JPA로 DB에 저장할 때, Enum값을 어떤 형태로 저장할 지 결정
    // int로 된 숫자가 저장됨(디폴트) -> 문자열로 보기 쉽게 저장하도록 설정
    @Column(nullable=false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, Role role){
        this.name=name;
        this.email=email;
        this.picture=picture;
        this.role=role;
    }

    public User update(String name, String picture){
        this.name=name;
        this.picture=picture;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

}
