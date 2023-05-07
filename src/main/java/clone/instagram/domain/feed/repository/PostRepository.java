package clone.instagram.domain.feed.repository;

import clone.instagram.domain.feed.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
//    @Query("select p from Post p join fetch p.memberId where p.id = :postId")
    @Query("SELECT p FROM Post p ORDER BY p.id DESC")
    Optional<Post> findWithMemberById(@Param("postId") Long postId);
}