package me.stef.fullstack.mapper;

import me.stef.fullstack.dto.*;
import me.stef.fullstack.model.Reservation;
import me.stef.fullstack.model.Screening;
import me.stef.fullstack.model.Show;
import me.stef.fullstack.model.User;

public interface MyMapper {

    static UserDTO toUserDto(User in) {
        return new UserDTO(in.getId(), in.getUsername(), in.getEmail());
    }

    static User toUser(RegisterUserDTO in) {
        return new User(in.getUsername(), in.getEmail(), in.getPassword());
    }

    static ShowDTO toShowDto(Show in) {
        return new ShowDTO(in.getId(), in.getTitle(), in.getDescription(), in.getDuration(), in.getDirector(), in.getGenre(), in.getLanguage());
    }

    static Show toShow(RegisterShowDTO in) {
        return new Show(in.getTitle(), in.getDescription(), in.getDuration(), in.getDirector(), in.getGenre(), in.getLanguage());
    }

    static ScreeningDTO toScreeningDto(Screening in) {
        return new ScreeningDTO(in.getId(), in.getDate(), in.getPrice());
    }

    static Screening toScreening(RegisterScreeningDTO in) {
        return new Screening(in.getDate(), in.getPrice());
    }

    static ReservationDTO toReservationDto(Reservation in) {
        ReservationDTO reservation = new ReservationDTO();
        reservation.setScreening(toScreeningDto(in.getScreening()));
        reservation.setUser(toUserDto(in.getUser()));
        reservation.setRegisteredAt(in.getRegisteredAt());

        return reservation;
    }
}
