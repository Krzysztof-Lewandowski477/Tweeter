package pl.tweeter.Tweeter.services.impl;



import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tweeter.Tweeter.domain.entity.Tweet;
import pl.tweeter.Tweeter.domain.repositories.TweetRepository;
import pl.tweeter.Tweeter.domain.repositories.UserRepository;

import pl.tweeter.Tweeter.dtos.UserTwittDataDTO;
import pl.tweeter.Tweeter.services.UserTwittService;
@Service
@Transactional
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

    @Override
    public void addTweet(UserTwittDataDTO userTwittDataDTO) {

        ModelMapper modelMapper = new ModelMapper ();
        Tweet tweet = modelMapper.map ( userTwittDataDTO,Tweet.class );
        tweetRepository.save ( tweet );

    }
}
