package me.stef.fullstack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReservationId implements Serializable {

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "SCREENING_ID")
    private Long screeningId;

    public ReservationId() {
    }

    public ReservationId(Long userId, Long screeningId) {
        this.userId = userId;
        this.screeningId = screeningId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(Long screeningId) {
        this.screeningId = screeningId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationId that = (ReservationId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(screeningId, that.screeningId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, screeningId);
    }
}
