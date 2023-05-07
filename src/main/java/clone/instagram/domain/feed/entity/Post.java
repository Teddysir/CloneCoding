package clone.instagram.domain.feed.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "posts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "member_id")
    private String memberId; // 나중에 member 객체로 교체

    @CreatedDate
    @Column(name = "post_date")
    private LocalDateTime uploadDate;

    @Lob
    @Column(name = "content")
    private String content;

    @Builder
    public Post(String memberId, String content){
        this.content = content;
        this.memberId = memberId;
    }
    public void update(String content){
        this.content = content;
    }
}
