package com.smart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.smart.constant.Constant.*;

@Controller
@RequestMapping(USER_CONTROLLER)
public class UserController {
    Logger logger= LoggerFactory.getLogger(UserController.class);
    @GetMapping(GET_DASHBOARD)
    public String getDashboard(Model model){
        model.addAttribute(TITLE,USER_DASHBOARD_PAGE);
        logger.info("inside dashBoard");
        return USER_DASHBOARD;
    }

}
