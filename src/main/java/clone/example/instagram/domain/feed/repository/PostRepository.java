package clone.example.instagram.domain.feed.repository;

import clone.example.instagram.domain.feed.entity.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    Post findByPostId(Long postId);
}
