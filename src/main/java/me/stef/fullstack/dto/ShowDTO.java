package me.stef.fullstack.dto;

import java.time.Instant;

public class ShowDTO {

    private Integer id;
    private String name;
    private String description;
    private Instant date;

    public ShowDTO() {
    }

    public ShowDTO(Integer id, String name, String description, Instant date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
}
