package me.stef.fullstack.dto;

import java.time.LocalDateTime;

public class ReservationDTO {

    private UserDTO user;
    private ScreeningDTO screening;
    private LocalDateTime registeredAt;

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public ScreeningDTO getScreening() {
        return screening;
    }

    public void setScreening(ScreeningDTO screening) {
        this.screening = screening;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }
}
