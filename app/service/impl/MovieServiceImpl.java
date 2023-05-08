package service.impl;

import controllers.MovieRequest;
import domain.Movie;
import repository.MovieRepository;
import service.MovieService;

import java.util.List;
import java.util.Optional;

public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAllMovies() {
        return movieRepository.findAll().stream().toList();
    }

    @Override
    public Optional<Movie> findMovieById(int movieId) {
        return Optional.ofNullable(movieRepository.getReferenceById(movieId));
    }

    @Override
    public Optional<Movie> createMovie(MovieRequest movieRequest) {
        Movie movie = new Movie();
        movie.setId(movieRequest.getId());
        movie.setTitle(movieRequest.getTitle());
        movie.setReleaseYear(movieRequest.getReleaseYear());
        movie.setDirectorId(movieRequest.getDirectorId());
        Movie newMovie = movieRepository.save(Optional.of(movie));
        return Optional.ofNullable(newMovie);
    }

    @Override
    public Optional<Movie> updateMovie(int movieId, MovieRequest movieRequest) {
        return Optional.ofNullable(movieRepository.findById(movieId).map(movie -> {
            movie.setTitle(movieRequest.getTitle());
            movie.setReleaseYear(movieRequest.getReleaseYear());
            movie.setGenre(movieRequest.getGenre());
            movie.setDirectorId(movieRequest.getDirectorId());
            return new Movie(movieRepository.save(Optional.of(movie)));
        }).orElseThrow(() -> new ResourceNotFoundException("Movie", "id", movieId+"")));
    }

    @Override
    public boolean deleteMovie(int movieId) {
        return movieRepository.findById(movieId).map(movie -> {
            movieRepository.delete(movie.getId());
            return true;
        }).orElseThrow(()-> new ResourceNotFoundException("Movie","id",""+movieId+""));
    }
}
