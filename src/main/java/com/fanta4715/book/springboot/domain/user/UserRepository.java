package com.fanta4715.book.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    //이미 생성된 사용자인지 처음 사용자인지 판단하기 위한 메소드
}
