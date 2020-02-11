package pl.tweeter.Tweeter.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.tweeter.Tweeter.domain.entity.Tweet;
import pl.tweeter.Tweeter.domain.repositories.TweetRepository;
import pl.tweeter.Tweeter.dtos.UserTwittDataDTO;
import pl.tweeter.Tweeter.services.impl.UserTwittServiceImpl;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class HomeController {

    private final TweetRepository tweetRepository;
    private final UserTwittServiceImpl userTwittService;

    public HomeController(TweetRepository tweetRepository, UserTwittServiceImpl userTwittService) {
        this.tweetRepository = tweetRepository;
        this.userTwittService = userTwittService;
    }

    @GetMapping("/")
    public String  getHomePage(){

        return "login";
    }

    @GetMapping("/index")
    public String getIndexPage(Model model ){
        List<Tweet> tweets = tweetRepository.findAll ();
        model.addAttribute ( "tweets" , tweets );
        model.addAttribute ( "newTweet", new UserTwittDataDTO ());

        return "index";
    }

    @PostMapping("/index")
    public String postIndexPage(@ModelAttribute("newTweet") @Valid UserTwittDataDTO userTwittDataDTO ,Long id, BindingResult result){
        if(result.hasErrors ()){
            return "redirect:/index";
        }
        userTwittService.addTweet ( userTwittDataDTO ,id);
        return "redirect:/index";
    }



}
