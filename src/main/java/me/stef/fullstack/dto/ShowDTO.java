package me.stef.fullstack.dto;

import java.util.List;

public class ShowDTO {

    private Long id;
    private String title;
    private String description;
    private String duration;
    private String director;
    private String genre;
    private String language;
    private List<UserDTO> likes;
    private List<ScreeningDTO> screenings;

    public ShowDTO() {
    }

    public ShowDTO(Long id, String title, String description, String duration, String director, String genre, String language) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.director = director;
        this.genre = genre;
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<UserDTO> getLikes() {
        return likes;
    }

    public void setLikes(List<UserDTO> likes) {
        this.likes = likes;
    }

    public List<ScreeningDTO> getScreenings() {
        return screenings;
    }

    public void setScreenings(List<ScreeningDTO> screenings) {
        this.screenings = screenings;
    }
}
