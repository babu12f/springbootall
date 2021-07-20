package com.babor.springbootall.controllers;

import com.babor.springbootall.beans.Product;
import com.babor.springbootall.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.Callable;

@Controller
public class SearchController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/search")
    public Callable<String> goToSearch(@RequestParam("search") String search, Model model, HttpServletRequest request) {
        System.out.println("Searching for : " + search);
        System.out.println("Async support in application: " + request.isAsyncSupported());
        System.out.println("Thread form the servlet Container: " + Thread.currentThread().getName());

        return () -> {
            Thread.sleep(3000);
            System.out.println("Thread form spring task executor: " + Thread.currentThread().getName());

            List<Product> products = productRepository.findByName(search);
            model.addAttribute("products", products);
            return "search";
        };
    }

}
