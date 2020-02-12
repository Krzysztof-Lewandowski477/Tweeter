package pl.tweeter.Tweeter.dtos;

import lombok.Data;
import pl.tweeter.Tweeter.domain.entity.User;

@Data
public class MessageDataDTO {

    private Long id;
    private User user;
    private String status;
    private String text;
    private User receiver;

}
