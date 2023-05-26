package clone.example.instagram.domain.feed.controller;

import clone.example.instagram.domain.feed.dto.PostUpdateDto;
import clone.example.instagram.domain.feed.dto.PostUploadRequest;
import clone.example.instagram.domain.feed.entity.post.Post;
import clone.example.instagram.domain.feed.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    // 게시물 모두 조회
    @GetMapping("/post")
    public List<Post> getPost() {
        return postService.getPost();
    }

    // 게시물 생성
    @PostMapping("/post")
    public ResponseEntity<String> createPost(@RequestBody PostUploadRequest uploadRequest){
        postService.createBoard(uploadRequest);
        return ResponseEntity.ok("게시글이 등록되었습니다.");
    }

    // 게시물 수정
    @PutMapping("/post/{id}")
    public ResponseEntity<String> updateMemo(@PathVariable Long id, @RequestBody PostUpdateDto updateDto) {
        postService.updatePost(id, updateDto);
        return ResponseEntity.ok("게시물이 수정되었습니다.");
    }

    // 게시물 삭제
    @DeleteMapping("/post/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return ResponseEntity.ok("게시물이 삭제되었습니다.");
    }

}
