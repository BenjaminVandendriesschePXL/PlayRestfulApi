package controllers;

import java.util.List;

public class MovieRequest {
    private int id;
    private String title;
    private int releaseYear;
    private String genre;
    private List <Integer> directorId;

    public MovieRequest(int id, String title, int releaseYear, String genre, List<Integer> directorId) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.directorId = directorId;
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

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Integer> getDirectorId() {
        return directorId;
    }

    public void setDirectorId(List<Integer> directorId) {
        this.directorId = directorId;
    }
}
