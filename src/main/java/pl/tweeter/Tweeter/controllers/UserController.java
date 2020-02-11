package pl.tweeter.Tweeter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.tweeter.Tweeter.Utils.Utils;
import pl.tweeter.Tweeter.domain.entity.User;
import pl.tweeter.Tweeter.domain.repositories.TweetRepository;
import pl.tweeter.Tweeter.domain.repositories.UserRepository;
import pl.tweeter.Tweeter.dtos.UserTwittDataDTO;
import pl.tweeter.Tweeter.services.impl.UserTwittServiceImpl;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserTwittServiceImpl userTwittService;
    private final UserRepository userRepository;
    private final TweetRepository tweetRepository;

    public UserController(UserTwittServiceImpl userTwittService, UserRepository userRepository, TweetRepository tweetRepository) {
        this.userTwittService = userTwittService;
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }

    @GetMapping("/account")
    public String preapreUserPage(Principal principal, Model model, Long id){
    User user = userRepository.findUserByEmail ( principal.getName () );
    model.addAttribute ( "allTwitt", userTwittService.showTwitt ( user.getId () ));
    model.addAttribute ( "tweet" , tweetRepository.findTweetsById (  id));

        return "user/account";
}


@GetMapping("/twitterdetails")
    public String getTwitterDetails( Long id, Model model){

         model.addAttribute ( "tweet" , tweetRepository.findTweetsById ( id));

    return "user/twitterdetails";
}





}
