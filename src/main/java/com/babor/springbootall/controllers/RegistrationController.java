package com.babor.springbootall.controllers;

import com.babor.springbootall.beans.User;
import com.babor.springbootall.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute("newuser") User user, Model model) {
        userRepository.save(user);

        model.addAttribute("dataSaved", "User Registered Successfully");
        return "login";
    }
}
