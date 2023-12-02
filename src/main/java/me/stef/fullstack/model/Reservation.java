package me.stef.fullstack.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "RESERVATIONS")
public class Reservation {

    @EmbeddedId
    private ReservationId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @MapsId("screeningId")
    @JoinColumn(name = "SCREENING_ID")
    private Screening screening;

    @Column(name = "DATE")
    private LocalDateTime registeredAt = LocalDateTime.now();

    public Reservation() {
    }

    public Reservation(Long userId, Long screeningId) {
        this.id = new ReservationId(userId, screeningId);
    }

    public Reservation(User user, Screening screening) {
        this.id = new ReservationId(user.getId(), screening.getId());
        this.user = user;
        this.screening = screening;
    }

    public ReservationId getId() {
        return id;
    }

    public void setId(ReservationId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }
}
