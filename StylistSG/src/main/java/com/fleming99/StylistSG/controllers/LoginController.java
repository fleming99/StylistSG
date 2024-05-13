package com.fleming99.StylistSG.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/home")
    public String showIndex(){
        return "landing-page/home";
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "login-directory/login-page";
    }

}
