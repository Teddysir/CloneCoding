package clone.example.instagram.domain.feed.dto.post;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostUpdateDto {
    private String content;

    public PostUpdateDto(String content){
        this.content = content;
    }
}
