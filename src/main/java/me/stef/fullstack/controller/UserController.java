package me.stef.fullstack.controller;

import me.stef.fullstack.dto.RegisterUserDTO;
import me.stef.fullstack.dto.UserDTO;
import me.stef.fullstack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return service.getUsers();
    }

    @PostMapping("/users")
    public UserDTO registerUser(
            @RequestBody RegisterUserDTO request) {
        return service.saveUser(request);
    }
}
