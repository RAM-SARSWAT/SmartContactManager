package com.smart.controller;

import com.smart.dto.UserDetailsRequest;
import com.smart.entity.UserDetails;
import com.smart.helper.Message;
import com.smart.service.UserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.smart.constant.Constant.*;

@Controller
@RequestMapping(TH)
public class RegisterController {
    @Autowired
    UserDetailService userDetailService;
    Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @PostMapping(value = REGISTER)
    public String registerUser(@Valid @ModelAttribute(USER) UserDetails userDetails,BindingResult bindingResult, @RequestParam(value = AGREEMENT, defaultValue = FALSE) Boolean agreement, Model model, HttpSession httpSession) {
        try {
            model.addAttribute(TITLE, SIGNUP);
            if (agreement) {
                userDetailService.registerUser(userDetails);
                model.addAttribute(USER, new UserDetailsRequest());
                httpSession.setAttribute(MESSAGE, new Message(SUCCESSFUL, "alert-success"));
                logger.info(REGISTER_MESSAGE);
                return SIGNUP_PAGE;
            } else if (bindingResult.hasErrors()) {
                model.addAttribute(USER,userDetails);
                return SIGNUP_PAGE;
            } else {
                throw new Exception(TC_ERROR);
            }
        } catch (Exception e) {
            model.addAttribute(USER, userDetails);
            httpSession.setAttribute(MESSAGE, new Message(ERROR_MSG + e.getMessage(), "alert-danger"));
            return SIGNUP_PAGE;
        }
    }
}
