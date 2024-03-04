package com.example.controller;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class WelcomeController {

    //config in application.properties
    @Value("${welcome.message}")
    private String message;

    private List<String> tasks = Arrays.asList(
            "You are developer.", "You are system analysis.", "You are automate tester."
    );

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);
        return "welcome"; //view
    }

    // /hello?name=kanokporn
    @GetMapping("/hello")
    public String mainWithParam(@RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("message", name);
        return "welcome"; //view
    }

}