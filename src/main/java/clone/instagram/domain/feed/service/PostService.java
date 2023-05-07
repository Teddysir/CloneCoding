package clone.instagram.domain.feed.service;

import clone.instagram.domain.feed.dto.PostDto;
import clone.instagram.domain.feed.dto.PostRequest;
import clone.instagram.domain.feed.dto.PostResponse;
import clone.instagram.domain.feed.entity.Post;
import clone.instagram.domain.feed.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long upload(PostRequest request){
        final Post post = Post.builder()
                .content(request.getContent())
                .build();
        return postRepository.save(post).getId();
    }
    public PostDto getPostDto(@PathVariable Long id){
        Post post = postRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        return new PostDto(post);
    }
    public Long delete(@PathVariable Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        postRepository.delete(post);
        return id;
    }
}
