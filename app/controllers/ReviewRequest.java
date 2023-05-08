package controllers;

import java.time.Instant;
import java.util.Date;

public class ReviewRequest {
    private Long id;
    private Long movieId;
    private Long userId;
    private String comment;
    private int rating;
    private Date timestamp;

    public ReviewRequest(Long id, Long movieId, Long userId, String comment, int rating) {
        this.id = id;
        this.movieId = movieId;
        this.userId = userId;
        this.comment = comment;
        this.rating = rating;
        this.timestamp = Date.from(Instant.now());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
