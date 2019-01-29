package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
