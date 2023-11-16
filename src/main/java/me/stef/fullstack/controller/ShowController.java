package me.stef.fullstack.controller;

import me.stef.fullstack.dto.ShowDTO;
import me.stef.fullstack.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShowController {

    @Autowired
    private ShowService service;

    @GetMapping("/shows")
    public List<ShowDTO> getShows() {
        return service.getShows();
    }
}
