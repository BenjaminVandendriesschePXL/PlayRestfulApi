package service;

import controllers.MovieRequest;
import domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> findAllMovies();
    Optional<Movie> findMovieById(int movieId);
    Optional<Movie> createMovie(MovieRequest movieRequest);
    Optional<Movie> updateMovie(int movieId, MovieRequest movieRequest);
    boolean deleteMovie(int movieId);
}
