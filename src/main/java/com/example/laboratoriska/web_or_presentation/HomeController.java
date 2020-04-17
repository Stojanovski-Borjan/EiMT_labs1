package com.example.laboratoriska.web_or_presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping
public class HomeController {
    @GetMapping
    public String getIndexPage() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String getHomePage(HttpServletRequest req, HttpServletResponse res){
        return "home";
    }
}
