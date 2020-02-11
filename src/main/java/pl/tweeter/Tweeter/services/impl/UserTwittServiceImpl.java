package pl.tweeter.Tweeter.services.impl;



import pl.tweeter.Tweeter.domain.repositories.TweetRepository;
import pl.tweeter.Tweeter.domain.repositories.UserRepository;

import pl.tweeter.Tweeter.services.UserTwittService;

public class UserTwittServiceImpl implements UserTwittService {

    private final UserRepository userRepository;
    private final TweetRepository tweetRepository;

    public UserTwittServiceImpl(UserRepository userRepository, TweetRepository tweetRepository) {
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }

    @Override
    public void showTwitt(Long id) {

        tweetRepository.findAllById ( id );
    }
}
