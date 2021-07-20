package com.babor.springbootall.controllers;

import com.babor.springbootall.beans.User;
import com.babor.springbootall.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/registerUser")
    public String registerUser(@Valid @ModelAttribute("newuser") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        userRepository.save(user);

        model.addAttribute("dataSaved", "User Registered Successfully");
        return "login";
    }
}
