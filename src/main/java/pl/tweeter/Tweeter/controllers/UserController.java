package pl.tweeter.Tweeter.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import pl.tweeter.Tweeter.domain.entity.User;
import pl.tweeter.Tweeter.domain.repositories.TweetRepository;
import pl.tweeter.Tweeter.domain.repositories.UserRepository;
import pl.tweeter.Tweeter.dtos.MessageDataDTO;

import pl.tweeter.Tweeter.services.impl.UserTwittServiceImpl;

import javax.validation.Valid;
import java.security.Principal;
@Slf4j
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
    model.addAttribute ( "tweet" , tweetRepository.findTweetsById (id));

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
            userTwittService.sendMessage ( messageDataDTO        );
        return "redirect:/user/message";
    }

    @GetMapping("/mymessages")
    public String getMyMessages(Model model, Principal principal){
        User user = userRepository.findUserByEmail ( principal.getName () );
        model.addAttribute ( "messageFind", userTwittService.showMessages ( user.getId () ) );

        return"user/mymessages";

    }

    @PostMapping("/mymessages")
    public String postMyMessages(){

        return"user/mymessages";
    }

}
