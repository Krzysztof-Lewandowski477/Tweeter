package pl.tweeter.Tweeter.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tweeter.Tweeter.domain.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role getByName(String name);


}
