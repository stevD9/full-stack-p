package me.stef.fullstack.controller.view;

import me.stef.fullstack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

//@Controller
public class UserViewController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public String getUsers(@RequestHeader("Host") String host, Model model) {
//        System.out.println("HOST HEADER : " + host); //test thymeleaf with headers (AUTH????)
        model.addAttribute("users", service.getUsers());
        return "users";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }
}
