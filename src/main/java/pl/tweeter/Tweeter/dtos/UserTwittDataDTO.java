package pl.tweeter.Tweeter.dtos;

import lombok.Data;
import pl.tweeter.Tweeter.domain.entity.User;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
public class UserTwittDataDTO {


    @ManyToOne(optional = false)
    @JoinColumn(name="userTweet_id")
    private User userTweet;
    private String text;
    private LocalDateTime created;
}
