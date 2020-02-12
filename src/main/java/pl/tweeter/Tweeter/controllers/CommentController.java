package pl.tweeter.Tweeter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.tweeter.Tweeter.domain.repositories.CommentRepository;
import pl.tweeter.Tweeter.domain.repositories.TweetRepository;
import pl.tweeter.Tweeter.dtos.CommentDataDTO;
import pl.tweeter.Tweeter.services.impl.CommentServiceImpl;

import javax.validation.Valid;

@Controller
public class CommentController {

    private final TweetRepository tweetRepository;
    private final CommentRepository commentRepository;
    private final CommentServiceImpl commentService;

    public CommentController(TweetRepository tweetRepository, CommentRepository commentRepository, CommentServiceImpl commentService) {
        this.tweetRepository = tweetRepository;

        this.commentRepository = commentRepository;
        this.commentService = commentService;
    }

    @GetMapping("/twittercomment")
    public String getComment( Long id , Model model){

        model.addAttribute ( "comments", commentRepository.findAllByTweetId ( id ) );
        model.addAttribute ( "tweet", tweetRepository.findTweetsById ( id ) );
        model.addAttribute ( "comment" , new CommentDataDTO ());

        return "twittercomment";
    }

    @PostMapping("/twittercomment")
    public String postComment (@ModelAttribute("comment") @Valid CommentDataDTO commentDataDTO,Long id, BindingResult result){
        if(result.hasErrors ()){
            return "redirect:/twittercomment";
        }
        commentService.addComment ( commentDataDTO, id);

        return "redirect:/twittercomment";
    }

}
