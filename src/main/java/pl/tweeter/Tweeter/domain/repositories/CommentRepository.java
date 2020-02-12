package pl.tweeter.Tweeter.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tweeter.Tweeter.domain.entity.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository <Comment, Long> {

    List<Comment> findAllByTweetId(Long id);
    Comment findAllByOrderByCreatedAsc();


}
