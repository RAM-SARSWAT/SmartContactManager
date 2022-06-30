package com.smart.controller;

import com.smart.entity.UserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/th")
public class UserController {
    Logger logger= LoggerFactory.getLogger(UserController.class);
    @PostMapping(value = "/register")
    public String registerUser(@ModelAttribute("user")UserDetails userDetails, @RequestParam(value = "agreement" ,defaultValue = "false")Boolean agreement, Model model){
        logger.info(agreement+"T&C");
        logger.info(userDetails.toString());
        return "signUp";
    }
}
