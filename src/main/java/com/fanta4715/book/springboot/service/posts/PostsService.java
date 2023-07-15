package com.fanta4715.book.springboot.service.posts;

import com.fanta4715.book.springboot.domain.post.Posts;
import com.fanta4715.book.springboot.domain.post.PostsRepository;
import com.fanta4715.book.springboot.web.dto.PostsListResponseDto;
import com.fanta4715.book.springboot.web.dto.PostsResponseDto;
import com.fanta4715.book.springboot.web.dto.PostsSaveRequestDto;
import com.fanta4715.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor //final이 선언된 모든 필드를 인자값으로하는 생성자
//의존성 관계 변경될 때마다 수정하지 않아도 됨
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){

        return postsRepository.save(requestDto.toEntity()).
                getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        //쿼리를 날리지 않는데도 기능함
        // JPA의 영속성 컨텍스트 : 엔티티를 영구 저장
        // JPA의 엔티티 매니저 활성화 도중 트랜잭션 안에서 DB가져오면
        // 이 데이터는 영속성 컨텍스트가 유지된 상태
        // 트랜잭션이 끝나는 시점에 변경을 테이블에 반영함
        // Entity "객체"의 값만 변경하면 Update 쿼리 날릴 필요x
        // 이것을 더티체킹이라고 한다
        Posts posts=postsRepository.findById(id)
                .orElseThrow(()->new
                        IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()-> new
                        IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
//   readOnly=true를 통해 트랜잭션 범위 유지
//    및 조회 기능만 남겨둠 -> 조회 속도 개선
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
//       스트림 해석 : 결과로 넘어온 Posts의 Stream을 map을 통해
//        PostsListReponseDto 변환 -> List로 반환하는 메소드

    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        postsRepository.delete(posts);
    }


}
