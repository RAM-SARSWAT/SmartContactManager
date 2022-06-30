package com.smart.controller;

import com.smart.entity.UserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/th")
public class HomeController {
    Logger logger=LoggerFactory.getLogger(HomeController.class);
    @GetMapping(value = "/")
    public String home(Model model){
        model.addAttribute("title","SCM");
        logger.info("Inside The Home Page");
        return "home";
    }
    @GetMapping(value = "/about")
    public String about(Model model){
        model.addAttribute("title","SCM");
        logger.info("Inside The about Page");
        return "about";
    }
    @GetMapping(value = "/signUp")
    public String signUp(Model model){
        model.addAttribute("title","SCM");
        model.addAttribute("user",new UserDetails());
        logger.info("Inside The SignUp Page");
        return "signUp";
    }

}
