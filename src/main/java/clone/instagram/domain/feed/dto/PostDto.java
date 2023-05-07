package clone.instagram.domain.feed.dto;

import clone.instagram.domain.feed.entity.Post;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostDto {

    private Long postId;
    private String memberId;
    private LocalDateTime uploadDate;
    private String content;

    public PostDto(Long postId, String memberId, LocalDateTime uploadDate, String content){
        this.postId = postId;
        this.memberId = memberId;
        this.uploadDate = uploadDate;
        this.content = content;
    }
    public PostDto(Post post){
        this.postId = post.getId();
        this.memberId = post.getMemberId();
        this.uploadDate = post.getUploadDate();
        this.content = post.getContent();
    }
}
