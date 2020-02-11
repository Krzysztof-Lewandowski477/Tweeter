package pl.tweeter.Tweeter.services;


import pl.tweeter.Tweeter.dtos.UserTwittDataDTO;

public interface UserTwittService {

    void showTwitt(Long id);

    void addTweet(UserTwittDataDTO userTwittDataDTO);


}
