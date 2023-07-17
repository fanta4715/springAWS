package com.fanta4715.book.springboot.web;

import com.fanta4715.book.springboot.service.posts.PostsService;
import com.fanta4715.book.springboot.web.dto.PostsResponseDto;
import com.fanta4715.book.springboot.web.dto.PostsSaveRequestDto;
import com.fanta4715.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
//post put delete get함수마다
    //각각 필요한 변수들이 다 다르다 (id, dto,...)
    private final PostsService postsService;


    @PostMapping("/api/v1/posts") // Post는 등록 Create
    public Long save(@RequestBody PostsSaveRequestDto
                     requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}") //Put은 수정 Update
    public Long update(@PathVariable Long id, @RequestBody
    PostsUpdateRequestDto requestDto){
        return postsService.update(id,requestDto);
    }
    @DeleteMapping("/api/v1/posts/{id}") //Delete는 삭제 Delete
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
    @GetMapping("/api/v1/posts/{id}") //Get은 조회 Read
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
