package com.smart.controller;

import com.smart.entity.UserDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.smart.constant.Constant.*;

@Controller
@RequestMapping(TH)
public class HomeController {
    Logger logger=LoggerFactory.getLogger(HomeController.class);
    @GetMapping(value = SEPARATOR)
    public String home(Model model){
        model.addAttribute(TITLE, HOME);
        logger.info("Inside The Home Page");
        return HOME_PAGE;
    }
    @GetMapping(value = ABOUT_URL)
    public String about(Model model){
        model.addAttribute(TITLE,ABOUT);
        logger.info("Inside The about Page");
        return ABOUT_PAGE;
    }
    @GetMapping(value = SIGNUP_URL)
    public String signUp(Model model){
        model.addAttribute(TITLE,SIGNUP);
        model.addAttribute(USER,new UserDetail());
        logger.info("Inside The SignUp Page");
        return SIGNUP_PAGE;
    }
@GetMapping(value = LOGIN_URL)
    public String login(Model model){
    model.addAttribute(TITLE,LOGIN);
    return LOGIN_PAGE;
}

}
