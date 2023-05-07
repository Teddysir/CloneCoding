package clone.instagram.domain.feed.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    @Size(max = 2200, message = "게시물 내용은 최대 2,200자까지 입력 가능합니다.")
    private String content;
}
