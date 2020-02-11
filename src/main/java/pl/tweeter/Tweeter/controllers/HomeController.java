package pl.tweeter.Tweeter.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.tweeter.Tweeter.domain.entity.Tweet;
import pl.tweeter.Tweeter.domain.entity.User;
import pl.tweeter.Tweeter.domain.repositories.TweetRepository;

import java.util.List;

@Slf4j
@Controller
public class HomeController {

    private final TweetRepository tweetRepository;

    public HomeController(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @GetMapping("/")
    public String  getHomePage(){

        return "login";
    }

    @GetMapping("/index")
    public String getIndexPage(Model model){
        List<Tweet> tweets = tweetRepository.findAll ();
        model.addAttribute ( "tweets" , tweets );
        return "index";
    }

}
