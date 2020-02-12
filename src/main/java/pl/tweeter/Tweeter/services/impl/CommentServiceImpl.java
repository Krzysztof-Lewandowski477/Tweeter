package pl.tweeter.Tweeter.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import pl.tweeter.Tweeter.domain.entity.Comment;
import pl.tweeter.Tweeter.domain.repositories.CommentRepository;
import pl.tweeter.Tweeter.dtos.CommentDataDTO;
import pl.tweeter.Tweeter.services.CommentService;

import java.time.LocalDateTime;

@Controller
@Transactional
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void addComment(CommentDataDTO commentDataDTO) {
        ModelMapper modelMapper = new ModelMapper ();
        //Ustawienie daty czasowej na polską
        LocalDateTime localDateTimePl = LocalDateTime.now ().plusHours ( 1 );
        Comment comment = modelMapper.map ( commentDataDTO, Comment.class);
        comment.setCreated ( localDateTimePl );
        commentRepository.save ( comment );
    }
}
