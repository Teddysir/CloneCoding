package clone.example.instagram.domain.feed.dto.post;


import clone.example.instagram.domain.feed.entity.post.Post;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
public class PostUploadRequest {

    private String member_id;
    private String content;

    @Builder
    public PostUploadRequest(String content, String member_id){
        this.content = content;
        this.member_id = member_id;
    }

    public Post toEntity() {
        return Post.builder()
                .member_id(member_id)
                .content(content)
                .build();
    }

}
