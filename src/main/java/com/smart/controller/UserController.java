package com.smart.controller;

import com.smart.entity.UserDetails;
import com.smart.service.UserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.smart.constant.Constant.*;

@Controller
@RequestMapping(TH)
public class UserController {
       @Autowired
       UserDetailService userDetailService;
    Logger logger= LoggerFactory.getLogger(UserController.class);
    @PostMapping(value = REGISTER)
    public String registerUser(@ModelAttribute(USER)UserDetails userDetails, @RequestParam(value = "agreement" ,defaultValue = "false")Boolean agreement, Model model){
        userDetailService.registerUser(userDetails);
        logger.info(REGISTER_MESSAGE);
        return SIGNUP_PAGE;
    }
}
