package me.stef.fullstack.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;

import me.stef.fullstack.dto.RegisterUserDTO;
import me.stef.fullstack.dto.UserDTO;
import me.stef.fullstack.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService service;

    @PostMapping("")
    public UserDTO registerUser(
            @RequestBody RegisterUserDTO request) {
        return service.saveUser(request);
    }

    @GetMapping("")
    public List<UserDTO> getUsers() {
        return service.getUsers();
    }

    @GetMapping("/profile") // here we will also have one that works with session id
    public UserDTO getUser(
            @AuthenticationPrincipal UserDetails userDetails) {
        return service.getUserByUsername(userDetails.getUsername());
    }

    @GetMapping("/username/{username}")
    public UserDTO getUser(
            @PathVariable("username") String username) {
        return service.getUserByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(
            @PathVariable("id") Long id) {
        service.deleteUser(id);
    }

    @PostMapping("/show/{showId}/like") // here we will also have one that works with session id and just pass the show id
    public void likeShow(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("showId") Long showId) {
        service.likeShow(userDetails.getUsername(), showId);
    }
}
