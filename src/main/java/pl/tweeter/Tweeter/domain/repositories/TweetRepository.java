package pl.tweeter.Tweeter.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tweeter.Tweeter.domain.entity.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    Tweet findAllById(Long id);

}
