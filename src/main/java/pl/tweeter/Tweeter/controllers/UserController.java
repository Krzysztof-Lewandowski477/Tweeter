package pl.tweeter.Tweeter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

@GetMapping("/account")
    public String preapreUserPage(Principal principal){
    String username = (principal.getName ());

    return "user/account";
}
@PostMapping("/account")
    String userAccount(){
    return "user/account";
}





}
