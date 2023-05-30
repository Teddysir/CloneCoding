package clone.example.instagram.domain.feed.dto.board.file;

import clone.example.instagram.domain.feed.entity.board.file.BoardFile;
import lombok.Getter;

@Getter
public class BoardFileResponseDto {

    private String origFileName;
    private String saveFileName;
    private String filePath;

    public BoardFileResponseDto(BoardFile entity) {
        this.filePath = entity.getFilePath();
        this.origFileName = entity.getOrigFileName();
        this.saveFileName = entity.getSaveFileName();
    }

    @Override
    public String toString() {
        return "FileMstResponseDto [origFileName=" + origFileName + ", saveFileName=" + saveFileName + ", filePath="+ filePath+"]";

    }
}
