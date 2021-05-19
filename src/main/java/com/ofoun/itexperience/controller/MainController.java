package com.ofoun.itexperience.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class MainController {
 
   @RequestMapping(value = { "/", "/iterfahringen_de" })	
    public String staticResource(Model model) {
        return "index";
    }
   
   @RequestMapping(value = {"/iterfahringen_fr" })	
   public String staticResource1(Model model) {
       return "iterfahringen_fr";
   }
   
   @RequestMapping(value = {"/iterfahringen_en" })	
   public String staticResource11(Model model) {
       return "iterfahringen_en";
   }
}