package pl.tweeter.Tweeter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tweeter.Tweeter.dtos.RegistrationDataDTO;
import pl.tweeter.Tweeter.services.impl.RegistrationServiceImpl;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final RegistrationServiceImpl registrationService;


    public RegistrationController(RegistrationServiceImpl registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String registerGet(Model model){

        model.addAttribute ( "register", new RegistrationDataDTO () );

        return "register-form";
    }

    @PostMapping
    public String registerPost(@ModelAttribute("register") @Valid RegistrationDataDTO register, BindingResult result){

        if(result.hasErrors ()){
            return "register-form";
        }
        registrationService.register ( register );

        return "index";
    }

}
