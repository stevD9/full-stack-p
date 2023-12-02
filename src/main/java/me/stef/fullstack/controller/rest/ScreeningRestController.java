package me.stef.fullstack.controller.rest;

import me.stef.fullstack.dto.RegisterScreeningDTO;
import me.stef.fullstack.dto.ScreeningDTO;
import me.stef.fullstack.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screenings")
public class ScreeningRestController {

    @Autowired
    private ScreeningService service;

    @PostMapping("")
    public ScreeningDTO registerScreening(
            @RequestBody RegisterScreeningDTO request) {
        return service.saveScreening(request);
    }

    @GetMapping("")
    public List<ScreeningDTO> getScreenings() {
        return service.getScreenings();
    }

    @GetMapping("/{id}")
    public ScreeningDTO getScreening(
            @PathVariable("id") Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteScreening(
            @PathVariable("id") Long id) {
        service.delete(id);
    }
}
