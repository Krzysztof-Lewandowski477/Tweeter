package pl.tweeter.Tweeter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import pl.tweeter.Tweeter.domain.entity.User;
import pl.tweeter.Tweeter.domain.repositories.MessageRepository;
import pl.tweeter.Tweeter.domain.repositories.TweetRepository;
import pl.tweeter.Tweeter.domain.repositories.UserRepository;
import pl.tweeter.Tweeter.dtos.MessageDataDTO;

import pl.tweeter.Tweeter.services.impl.UserTwittServiceImpl;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserTwittServiceImpl userTwittService;
    private final UserRepository userRepository;
    private final TweetRepository tweetRepository;
    private final MessageRepository messageRepository;



    public UserController(UserTwittServiceImpl userTwittService, UserRepository userRepository, TweetRepository tweetRepository, MessageRepository messageRepository) {
        this.userTwittService = userTwittService;
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
        this.messageRepository = messageRepository;

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


@GetMapping("/message")
    public String getMessagePage (Model model){
        model.addAttribute ( "message" , new MessageDataDTO () );
        return "user/message";
}

    @PostMapping("/message")
    public String potMessagePage (@ModelAttribute("message") @Valid MessageDataDTO messageDataDTO , Long id, BindingResult result) {
            if (result.hasErrors ()){
                return "redirect:/user/message";
            }
            userTwittService.sendMessage ( messageDataDTO , id );
        return "user/message";
    }

    @GetMapping("/mymessages")
    public String getMyMessages(Model model, Long id){

        model.addAttribute ( "messagefind", messageRepository.findAllByUserId ( id ) );
        return"user/mymessages";
    }

}
