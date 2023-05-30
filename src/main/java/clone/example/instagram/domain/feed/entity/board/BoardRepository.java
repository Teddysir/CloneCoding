package clone.example.instagram.domain.feed.entity.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BoardRepository extends JpaRepository<Board,Long> {

    static final String UPDATE_BOARD = "UPDATE Board "
            + "SET TITLE = :#{#boardRequestDto.title}, "
            + "CONTENT = :#{#boardRequestDto.content}, "
            + "REGISTER_ID = :#{#boardRequestDto.registerId}, "
            + "UPDATE_TIME = NOW() "
            + "WHERE ID = :#{#boardRequestDto.id}";


}

