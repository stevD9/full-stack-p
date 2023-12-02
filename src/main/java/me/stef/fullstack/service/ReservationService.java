package me.stef.fullstack.service;

import me.stef.fullstack.dao.ReservationRepository;
import me.stef.fullstack.dao.ScreeningRepository;
import me.stef.fullstack.dao.UserRepository;
import me.stef.fullstack.dto.ReservationDTO;
import me.stef.fullstack.mapper.MyMapper;
import me.stef.fullstack.model.Reservation;
import me.stef.fullstack.model.ReservationId;
import me.stef.fullstack.model.Screening;
import me.stef.fullstack.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScreeningRepository screeningRepository;

    public ReservationDTO save(Long userId, Long screeningId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Not found"));

        Screening screening = screeningRepository.findById(screeningId)
                .orElseThrow(() -> new RuntimeException("Not found"));

        Reservation reservation = new Reservation(user, screening);
        reservationRepository.save(reservation);

        return MyMapper.toReservationDto(reservation);
    }

    public List<ReservationDTO> getReservations() {
        return reservationRepository.findAll().stream()
                .map(MyMapper::toReservationDto)
                .toList();
    }

    public ReservationDTO getById(Long userId, Long screeningId) {
        return reservationRepository.findById(new ReservationId(userId, screeningId))
                .map(MyMapper::toReservationDto)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    public List<ReservationDTO> getReservationsForUser(Long userId) {
        return reservationRepository.findForUser(userId).stream()
                .map(MyMapper::toReservationDto)
                .toList();
    }

    public void delete(Long userId, Long screeningId) {
        reservationRepository.deleteById(new ReservationId(userId, screeningId));
    }
}
