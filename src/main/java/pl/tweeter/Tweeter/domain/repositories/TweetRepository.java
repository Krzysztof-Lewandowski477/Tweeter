package pl.tweeter.Tweeter.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tweeter.Tweeter.domain.entity.Tweet;

import java.util.List;


public interface TweetRepository extends JpaRepository<Tweet, Long> {

    List<Tweet> findAllByUserId(Long id);
        Tweet findTweetsById(Long id);

}
