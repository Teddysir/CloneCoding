package clone.example.instagram.domain.feed.dto.post;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostDto {
    private Long postId;
    private String member_id;
    private String content;
    private LocalDateTime uploadDate;

    @Builder
    public PostDto(Long postId, String content, String member_id,LocalDateTime uploadDate){
        this.postId = getPostId();
        this.member_id = getMember_id();
        this.content = getContent();
        this.uploadDate = getUploadDate();
    }





}
