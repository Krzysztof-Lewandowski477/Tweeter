package pl.tweeter.Tweeter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String prepareLoginPage(HttpServletRequest request){
        if(request.isUserInRole ( "ROLE_USER" )){
            return "index";
        }else if(request.isUserInRole ( "ROLE_ADMIN" )){
            return "index";
        }
        return "login";
    }

}
