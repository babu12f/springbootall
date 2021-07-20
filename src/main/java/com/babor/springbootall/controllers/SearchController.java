package com.babor.springbootall.controllers;

import com.babor.springbootall.beans.Product;
import com.babor.springbootall.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    @Qualifier("applicationAsyncTaskExecutor")
    private AsyncTaskExecutor asyncTaskExecutor;

    @GetMapping("/search")
    public DeferredResult<String> goToSearch(@RequestParam("search") String search, Model model, HttpServletRequest request) {
        DeferredResult<String> deferredResult = new DeferredResult<>();
        System.out.println("Searching for : " + search);
        System.out.println("Async support in application: " + request.isAsyncSupported());
        System.out.println("Thread form the servlet Container: " + Thread.currentThread().getName());

        /*return () -> {
            Thread.sleep(3000);
            System.out.println("Thread form spring task executor: " + Thread.currentThread().getName());

            List<Product> products = productRepository.findByName(search);
            model.addAttribute("products", products);
            return "search";
        };*/

        asyncTaskExecutor.execute(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread form spring task executor: " + Thread.currentThread().getName());

            List<Product> products = productRepository.findByName(search);
            model.addAttribute("products", products);
            deferredResult.setResult("search");
        });
        return deferredResult;
    }

}
