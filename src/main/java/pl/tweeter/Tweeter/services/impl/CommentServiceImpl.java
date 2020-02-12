package pl.tweeter.Tweeter.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import pl.tweeter.Tweeter.Utils.Utils;
import pl.tweeter.Tweeter.domain.entity.Comment;
import pl.tweeter.Tweeter.domain.repositories.CommentRepository;
import pl.tweeter.Tweeter.domain.repositories.TweetRepository;
import pl.tweeter.Tweeter.domain.repositories.UserRepository;
import pl.tweeter.Tweeter.dtos.CommentDataDTO;
import pl.tweeter.Tweeter.services.CommentService;

import java.time.LocalDateTime;

@Controller
@Transactional
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final TweetRepository tweetRepository;

    public CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository, TweetRepository tweetRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }

    @Override
    public void addComment(CommentDataDTO commentDataDTO, Long id) {
        ModelMapper modelMapper = new ModelMapper ();
        //Ustawienie daty czasowej na polską
        LocalDateTime localDateTimePl = LocalDateTime.now ().plusHours ( 1 );
        Comment comment = modelMapper.map ( commentDataDTO, Comment.class);
        comment.setCreated ( localDateTimePl );
        comment.setUser (userRepository.findUserByEmail ( Utils.getName () ));
        comment.setTweet (tweetRepository.getOne ( commentDataDTO.getTwitterId () ));
        commentRepository.save ( comment );
    }
}
