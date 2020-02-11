package pl.tweeter.Tweeter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tweeter.Tweeter.domain.entity.Tweet;
import pl.tweeter.Tweeter.domain.entity.User;
import pl.tweeter.Tweeter.domain.repositories.UserRepository;
import pl.tweeter.Tweeter.services.impl.UserTwittServiceImpl;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserTwittServiceImpl userTwittService;
    private final UserRepository userRepository;

    public UserController(UserTwittServiceImpl userTwittService, UserRepository userRepository) {
        this.userTwittService = userTwittService;
        this.userRepository = userRepository;
    }

    @GetMapping("/account")
    public String preapreUserPage(Principal principal, Model model){
    User user = userRepository.findUserByEmail ( principal.getName () );
    model.addAttribute ( "allTwitt", userTwittService.showTwitt ( user.getId () ));
    return "user/account";
}
@PostMapping("/account")
    String userAccount(){
    return "user/account";
}





}
