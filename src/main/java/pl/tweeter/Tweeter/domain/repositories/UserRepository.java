package pl.tweeter.Tweeter.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.tweeter.Tweeter.domain.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByEmail(String email);
    User findUserById(Long id);
}
