package pl.tweeter.Tweeter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

@GetMapping
    public String preapreUserPage(Principal principal){
    String username = (principal.getName ());

    return "index";
}





}
