package clone.instagram.domain.feed.controller;
import clone.instagram.domain.feed.dto.PostDto;
import clone.instagram.domain.feed.dto.PostRequest;
import clone.instagram.domain.feed.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping
    public Long save(@RequestBody PostRequest request){
        return postService.upload(request);
    }
    @GetMapping("/{id}")
    public PostDto getPost (@PathVariable Long id) {
        return postService.getPostDto(id);
    }

    @DeleteMapping
    public Long delete(@RequestParam Long id) {
        return postService.delete(id);
    }

    //    @PostMapping(".{id}")
    //    public Long update(@PathVariable Long id, @RequestBody PostRequest request){
    //        return postService.update(id, request);
    //    }
}
