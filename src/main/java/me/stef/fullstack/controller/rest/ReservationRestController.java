package me.stef.fullstack.controller.rest;

import me.stef.fullstack.dto.ReservationDTO;
import me.stef.fullstack.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationRestController {

    @Autowired
    private ReservationService service;

    @PostMapping("/users/{userId}/screening/{screeningId}") // here we will also have one that works with session id and just pass the screening id
    public ReservationDTO registerReservation(
            @PathVariable("userId") Long userId,
            @PathVariable("screeningId") Long screeningId) {
        return service.save(userId, screeningId);
    }

    @GetMapping("/users/{userId}/screening/{screeningId}") // here we will also have one that works with session id and just pass the screening id
    public ReservationDTO getReservations(
            @PathVariable("userId") Long userId,
            @PathVariable("screeningId") Long screeningId) {
        return service.getById(userId, screeningId);
    }

    @GetMapping("")
    public List<ReservationDTO> getReservations() {
        return service.getReservations();
    }

    @GetMapping("/users/{userId}") // here we will also have one that works with session id
    public List<ReservationDTO> getReservations(
            @PathVariable("userId") Long userId) {
        return service.getReservationsForUser(userId);
    }

    @DeleteMapping("/users/{userId}/screening/{screeningId}")
    public void deleteReservations(
            @PathVariable("userId") Long userId,
            @PathVariable("screeningId") Long screeningId) {
        service.delete(userId, screeningId);
    }
}
