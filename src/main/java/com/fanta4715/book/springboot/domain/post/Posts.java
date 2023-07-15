package com.fanta4715.book.springboot.domain.post;

import com.fanta4715.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Posts 클래스 == DB와 매칭될 클래스
//Entity 클랫라고도 함
//DB에 쿼리를 날리기보다 이 Entity클래스 수정으로 작업
@Getter//롬복 어노테이션
@NoArgsConstructor//롬복 어노테이션
@Entity//JPA 어노테이션
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=500, nullable=false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    private String author;

    @Builder //빌더 패턴 클래스 생성.
    //빌더 -> 생성자의 파라미터를 매핑하게 도와줌
    public Posts(String title,String content,String author)
    {
        this.title=title;
        this.content=content;
        this.author=author;
    }

    public void update(String title, String content){
        this.title=title;
        this.content=content;
    }
}
