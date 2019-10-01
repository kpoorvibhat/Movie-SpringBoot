package com.stackroute.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    private Integer id;
    private String title;
    private boolean adult;
    private String overview;

    public Movie() {
    }

    public Movie(int id, String title, boolean adult, String overview) {
        this.id = id;
        this.title = title;
        this.adult = adult;
        this.overview = overview;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", adult=" + adult +
                ", overview='" + overview + '\'' +
                '}';
    }
}
