package com.fanta4715.book.springboot.domain.post;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    //DB Layer접근자
    //JpaRepository<Entity클래스, PK타입> 상속하면
    //기본적인 CRUD 메소드 자동 생성
    //Entity클래스와 함께 위치해야 함
}
