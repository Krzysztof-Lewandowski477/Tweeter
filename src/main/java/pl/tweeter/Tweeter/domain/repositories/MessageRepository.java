package pl.tweeter.Tweeter.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.tweeter.Tweeter.domain.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository <Message , Long> {


    Message findAllByUserId(Long id);
    Message findAllByReceiverId(Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE message SET status ='odebrany' WHERE id = ?1",nativeQuery = true)
    void changeStatusToGet(Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE message SET status ='nieodebrany' WHERE id = ?1",nativeQuery = true)
    void changeStatusToUnGet(Long id);
}
