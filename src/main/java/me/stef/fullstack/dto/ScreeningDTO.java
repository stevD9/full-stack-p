package me.stef.fullstack.dto;

import java.util.Date;
import java.util.List;

public class ScreeningDTO {

    private Long id;
    private Date date;
    private double price;
    private ShowDTO show;
    private List<UserDTO> reservations;

    public ScreeningDTO() {
    }

    public ScreeningDTO(Long id, Date date, double price) {
        this.id = id;
        this.date = date;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ShowDTO getShow() {
        return show;
    }

    public void setShow(ShowDTO show) {
        this.show = show;
    }

    public List<UserDTO> getReservations() {
        return reservations;
    }

    public void setReservations(List<UserDTO> reservations) {
        this.reservations = reservations;
    }
}