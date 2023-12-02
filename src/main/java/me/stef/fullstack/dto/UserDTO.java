package me.stef.fullstack.dto;

import java.util.List;

public class UserDTO {

    private Long id;
    private String username;
    private String email;
    private List<ShowDTO> likedShows;
    private List<ScreeningDTO> reservations;

    public UserDTO() {
    }

    public UserDTO(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ShowDTO> getLikedShows() {
        return likedShows;
    }

    public void setLikedShows(List<ShowDTO> likedShows) {
        this.likedShows = likedShows;
    }

    public List<ScreeningDTO> getReservations() {
        return reservations;
    }

    public void setReservations(List<ScreeningDTO> reservations) {
        this.reservations = reservations;
    }
}
