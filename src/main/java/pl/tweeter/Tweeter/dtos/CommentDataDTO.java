package pl.tweeter.Tweeter.dtos;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.tweeter.Tweeter.domain.entity.Tweet;
import pl.tweeter.Tweeter.domain.entity.User;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
public class CommentDataDTO {


    private User user;
    private Tweet tweet;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;
    private String text;
}
