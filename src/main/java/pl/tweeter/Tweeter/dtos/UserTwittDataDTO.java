package pl.tweeter.Tweeter.dtos;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import pl.tweeter.Tweeter.domain.entity.User;


import java.time.LocalDateTime;
@Slf4j
@Data
public class UserTwittDataDTO {

    private Long id;
    private User user;
    private String text;
    private LocalDateTime created;

}
