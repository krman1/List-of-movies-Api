package pl.krman.list.of.movies;

import java.time.LocalDate;

public class Movie {

    private long id;
    private String title;
    private String genre;
    private String director;
    private LocalDate productionYear;

    public Movie() {
    }

    public Movie(long id, String title, String genre, String director, LocalDate productionYear) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.productionYear = productionYear;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public LocalDate getProductionYear() {
        return productionYear;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setProductionYear(LocalDate productionYear) {
        this.productionYear = productionYear;
    }
}
