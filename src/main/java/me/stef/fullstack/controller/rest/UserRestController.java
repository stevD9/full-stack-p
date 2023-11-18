package me.stef.fullstack.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;

import me.stef.fullstack.dto.RegisterUserDTO;
import me.stef.fullstack.dto.UserDTO;
import me.stef.fullstack.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @Autowired
    private UserService service;

    @PostMapping("/users")
    public UserDTO registerUser(
            @RequestBody RegisterUserDTO request) {
        return service.saveUser(request);
    }
}
