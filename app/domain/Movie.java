package domain;

import java.util.List;
import java.util.function.Consumer;

public class Movie {


    private int id;
    private String title;
    private int releaseYear;

    private String genre;
    private List<Integer> directorId;

    public Movie(int id, String title, int releaseYear, String genre, List<Integer> directorId) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.directorId = directorId;
    }

    public Movie(Movie save) {}

    public Movie() {

    }

    public void setId(int id) {this.id = id;}
    public int getId() {return id;}

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
    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", Genre='" + genre + '\'' +
                ", directorId=" + directorId +
                '}';
    }
}
