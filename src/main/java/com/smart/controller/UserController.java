package com.smart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.smart.constant.Constant.*;

@Controller
@RequestMapping(USER_CONTROLLER)
public class UserController {


    @GetMapping(GET_DASHBOARD)
    public String getDashboard(){
        return USER_DASHBOARD;
    }

}
