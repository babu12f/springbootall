package com.babor.springbootall.controllers;

import com.babor.springbootall.beans.Login;
import com.babor.springbootall.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getRoot() {
        return "index";
    }

    @GetMapping("/home")
    public String getHome() {
        return "index";
    }

    @GetMapping("/goToSearch")
    public String goToSearch() {
        return "search";
    }

    @GetMapping("/goToLogin")
    public String goToLogin() {
        return "login";
    }

    @GetMapping("/goToRegister")
    public String goToRegister() {
        return "register";
    }

    /*@ModelAttribute("newuser")
    public User getDefaultUser() {
        return new User();
    }

    @ModelAttribute("genderItems")
    public List<String> getgenderItems() {
        return Arrays.asList(new String[] {"Male", "Female", "Other"});
    }

    @ModelAttribute("login")
    public Login getDefaultLogin() {
        return new Login();
    }*/

}
