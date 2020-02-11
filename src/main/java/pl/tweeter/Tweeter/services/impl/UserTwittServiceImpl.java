package pl.tweeter.Tweeter.services.impl;



import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tweeter.Tweeter.Utils.Utils;
import pl.tweeter.Tweeter.domain.entity.Tweet;
import pl.tweeter.Tweeter.domain.repositories.TweetRepository;
import pl.tweeter.Tweeter.domain.repositories.UserRepository;

import pl.tweeter.Tweeter.dtos.UserTwittDataDTO;
import pl.tweeter.Tweeter.services.UserTwittService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


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
    public List<UserTwittDataDTO> showTwitt(Long id) {

        ModelMapper modelMapper = new ModelMapper ();
        List<Tweet> tweets = tweetRepository.findAllByUserId (id);
        return  tweets.stream ()
                .map ( b->modelMapper.map ( b, UserTwittDataDTO.class ) )
                .collect ( Collectors.toList () );

    }

    @Override
    public void addTweet(UserTwittDataDTO userTwittDataDTO, Long id) {
        //Ustawienie daty czasowej na polską
        LocalDateTime localDateTimePl = LocalDateTime.now ().plusHours ( 1 );
        ModelMapper modelMapper = new ModelMapper ();
        Tweet tweet = modelMapper.map ( userTwittDataDTO,Tweet.class );
        tweet.setCreated ( localDateTimePl);
        tweet.setUser ( userRepository.findUserByEmail ( Utils.getName() ) );

        tweetRepository.save ( tweet );

    }
}
