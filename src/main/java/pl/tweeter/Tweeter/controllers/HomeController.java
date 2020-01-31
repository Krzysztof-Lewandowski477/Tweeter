package pl.tweeter.Tweeter.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Slf4j
@Controller
public class HomeController {

    @GetMapping("/")
    public String  getHomePage(){

        return "login";
    }

    @GetMapping("/index")
    public String getIndexPage(){

        return "index";
    }

}
