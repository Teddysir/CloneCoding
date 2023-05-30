package clone.example.instagram.domain.feed.dto.board;

import clone.example.instagram.domain.feed.entity.board.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardRequestDto {
    private Long id;
    private String title;
    private String content;
    private String registerId;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .registerId(registerId)
                .build();
    }

    @Override
    public String toString() {
        return "BoardRequestDto [id=" + id + ", title=" + title + ", content=" + content + ", registerId=" +registerId +"]";
    }
}
