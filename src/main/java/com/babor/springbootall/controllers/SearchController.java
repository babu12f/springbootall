package com.babor.springbootall.controllers;

import com.babor.springbootall.beans.Product;
import com.babor.springbootall.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/search")
    public String goToSearch(@RequestParam("search") String search, Model model) {
        System.out.println("Searching for : " + search);

        List<Product> products = productRepository.findByName(search);

        model.addAttribute("products", products);

        return "search";
    }

}
