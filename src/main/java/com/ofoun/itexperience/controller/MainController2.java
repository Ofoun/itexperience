package com.ofoun.itexperience.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class MainController2 {
 
   @RequestMapping(value = "/{locale:en|fr|de}/login2")
    public String login2(Model model) {
        return "login2";
    }
 
}