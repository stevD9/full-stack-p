package me.stef.fullstack.controller.rest;

import me.stef.fullstack.dto.ReservationDTO;
import me.stef.fullstack.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationRestController {

    @Autowired
    private ReservationService service;

    @PostMapping("/screening/{screeningId}") // here we will also have one that works with session id and just pass the screening id
    public ReservationDTO registerReservation(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("screeningId") Long screeningId) {
        return service.save(userDetails.getUsername(), screeningId);
    }

    @GetMapping("/screening/{screeningId}") // here we will also have one that works with session id and just pass the screening id
    public ReservationDTO getReservations(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("screeningId") Long screeningId) {
        return service.getById(userDetails.getUsername(), screeningId);
    }

    @GetMapping("")
    public List<ReservationDTO> getReservations() {
        return service.getReservations();
    }

    @GetMapping("/users") // here we will also have one that works with session id
    public List<ReservationDTO> getReservations(
            @AuthenticationPrincipal UserDetails userDetails) {
        return service.getReservationsForUser(userDetails.getUsername());
    }

    @DeleteMapping("/users/{userId}/screening/{screeningId}")
    public void deleteReservations(
            @PathVariable("userId") Long userId,
            @PathVariable("screeningId") Long screeningId) {
        service.delete(userId, screeningId);
    }
}
