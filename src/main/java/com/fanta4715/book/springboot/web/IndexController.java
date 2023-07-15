package com.fanta4715.book.springboot.web;

import com.fanta4715.book.springboot.service.posts.PostsService;
import com.fanta4715.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    @GetMapping("/")
// Model : 서버 템플릿 엔진에서 사용할 수 있는 객체 저장
// findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달
    public String index(Model model){
        model.addAttribute("posts",postsService.findAllDesc());
        return "index";
        //머스테치가 문자열 앞에 경로를
        // 문자열 뒤에 확장자를 자동으로 지정해줌
        // 우리는 결국 src/main/resources/templates/index.mustache를 반환
        // 이걸 View Resolver가 처리
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
    
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        //entity를 건드리는 걸 entity수정으로 하면 위험
        //그래서 dto로 정보를 전달함
        // dto를 활용해서 model에 추가함
        // model은 "posts"에 dto의 결과를 전달해줌
        // 어디로? posts-update.mustache로
        model.addAttribute("post",dto);
        return "posts-update";
    }
}
