package clone.example.instagram.domain.feed.service;

import clone.example.instagram.domain.feed.dto.PostUpdateDto;
import clone.example.instagram.domain.feed.dto.PostUploadRequest;
import clone.example.instagram.domain.feed.entity.post.Post;
import clone.example.instagram.domain.feed.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final PostRepository postRepository;

    // C 생성
    public Long createBoard(PostUploadRequest uploadRequest){
        return postRepository.save(uploadRequest.toEntity()).getPostId();
    }

    // R 조회
    public List<Post> getPost() {
        return postRepository.findAll();
    }

    // U 수정
    public Long updatePost(Long id, PostUpdateDto updateDto){
        Post post = postRepository.findByPostId(id);
        post.update(updateDto.getContent());
        return id;
    }

    // D 삭제
    public void deletePost(Long id){
        Post post = postRepository.findByPostId(id);
        postRepository.delete(post);
    }

}



