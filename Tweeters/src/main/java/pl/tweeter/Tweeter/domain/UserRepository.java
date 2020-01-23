package pl.tweeter.Tweeter.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tweeter.Tweeter.domain.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {



}
