package pl.tweeter.Tweeter.services;


import pl.tweeter.Tweeter.domain.entity.Tweet;
import pl.tweeter.Tweeter.dtos.MessageDataDTO;
import pl.tweeter.Tweeter.dtos.UserTwittDataDTO;

import java.util.List;

public interface UserTwittService {

    List<UserTwittDataDTO> showTwitt(Long id);
    void showTwitterDetails(Long id);
    void addTweet(UserTwittDataDTO userTwittDataDTO, Long id);
    void sendMessage(MessageDataDTO messageDataDTO);


}
