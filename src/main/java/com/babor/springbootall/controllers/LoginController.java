package com.babor.springbootall.controllers;

import com.babor.springbootall.beans.Login;
import com.babor.springbootall.beans.User;
import com.babor.springbootall.exceptions.ApplicationException;
import com.babor.springbootall.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@ModelAttribute("login") Login login) {
        User user = userRepository.findByUsername(login.getUsername());

        if (user == null) {
            throw new ApplicationException("User not found");
        }

        return "search";
    }

    /*@ExceptionHandler(ApplicationException.class)
    public String handleException() {
        System.out.println("in the login exception handler");
        return "error";
    }*/
}
