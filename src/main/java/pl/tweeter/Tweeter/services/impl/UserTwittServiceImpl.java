package pl.tweeter.Tweeter.services.impl;



import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tweeter.Tweeter.Utils.Utils;
import pl.tweeter.Tweeter.domain.entity.Message;
import pl.tweeter.Tweeter.domain.entity.Tweet;
import pl.tweeter.Tweeter.domain.repositories.MessageRepository;
import pl.tweeter.Tweeter.domain.repositories.TweetRepository;
import pl.tweeter.Tweeter.domain.repositories.UserRepository;

import pl.tweeter.Tweeter.dtos.MessageDataDTO;
import pl.tweeter.Tweeter.dtos.UserTwittDataDTO;
import pl.tweeter.Tweeter.services.UserTwittService;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class UserTwittServiceImpl implements UserTwittService {

    private final UserRepository userRepository;
    private final TweetRepository tweetRepository;
    private final MessageRepository messageRepository;


    public UserTwittServiceImpl(UserRepository userRepository, TweetRepository tweetRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
        this.messageRepository = messageRepository;

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
    public List<MessageDataDTO> showMessages(Long id) {
        ModelMapper modelMapper = new ModelMapper ();
        List<Message> messages =   (messageRepository.findAllByReceiverId ( id ));
        return  messages.stream ()
                .map ( b->modelMapper.map ( b, MessageDataDTO.class ) )
                .collect ( Collectors.toList () );
    }

    @Override
    public void showTwitterDetails(Long id) {
        tweetRepository.findTweetsById ( id );
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

    @Override
    public void sendMessage(MessageDataDTO messageDataDTO, Long id) {
        ModelMapper modelMapper = new ModelMapper ();

        Message message = modelMapper.map ( messageDataDTO, Message.class );
        message.setStatus ( "nieodebrany" );

        message.setUser( userRepository.findUserByEmail ( Utils.getName () ) );
        message.setReceiver ( userRepository.findUserById ( id ) );
        messageRepository.save ( message );


    }
}
