package clone.example.instagram.domain.feed.entity.post;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "posts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long postId;

    @Column(name = "member_id")
    private String member_id;

    @Lob
    @Column(name = "content")
    private String content;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime uploadDate;

    // 이거 String 나중에 바꿔야할듯
    @Builder
    public Post(String member_id, String content){
        this.member_id = member_id;
        this.content = content;
    }

    public void update(String content){
        this.content = content;
    }

    // 나중에 수정 날짜도 추가하기 modified_at
    @PrePersist
    public void onPrePersist() {
        this.uploadDate = LocalDateTime.now();
    }


}
