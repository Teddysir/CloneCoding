package clone.example.instagram.domain.feed.dto;


import clone.example.instagram.domain.feed.entity.Post;
import lombok.*;

import javax.validation.constraints.Size;


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
