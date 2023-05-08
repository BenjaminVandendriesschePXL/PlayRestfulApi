package repository;

import domain.Movie;

import java.util.*;

public class MovieRepository {
    private Map<Integer, Movie> movies = new HashMap<>();

    public MovieRepository() {
        save(Optional.of(new Movie(1, "Avatar", 2009, "Action Adventure Fantasy Sci-Fi", List.of(1))));
        save(Optional.of(new Movie(2, "Avangers:Endgame", 2019, "Action Adventure Drama Sci-Fi", List.of(2, 3))));
        save(Optional.of(new Movie(3, "Avatar: The Way of Water", 2022, "Action Adventure Fantasy Sci-Fi", List.of(1))));
        save(Optional.of(new Movie(4, "Titanic", 1997, "Drama Romance", List.of(1))));
        save(Optional.of(new Movie(5, "Star Wars: Episode VII", 2015, "Action Adventure Sci-Fi", List.of(4))));
        save(Optional.of(new Movie(6, "Avengers:Infinity War", 2018, "Action Adventure Sci-Fi", List.of(2, 3))));
        save(Optional.of(new Movie(7, "Spider-Man:No Way Home", 2021, "Action Adventure Fantasy Sci-Fi", List.of(5))));
        save(Optional.of(new Movie(8, "Jurassic World", 2015, "Action Adventure Sci-Fi", List.of(6))));
        save(Optional.of(new Movie(9, "The Lion King", 2019, "Adventure Animation Drama Family Musical", List.of(7))));
        save(Optional.of(new Movie(10, "The Avengers", 2012, "Action Sci-Fi", List.of(81))));
        save(Optional.of(new Movie(11, "Furious 7", 2015, "Action Crime Thriller", List.of(9))));
        save(Optional.of(new Movie(12, "Top Gun: Maverick", 2022, "Action Drama", List.of(10))));
        save(Optional.of(new Movie(13, "Frozen II", 2019, "Adventure Animation Comedy Drama Family Fantasy Musical", List.of(11, 12))));
        save(Optional.of(new Movie(14, "Avengers:Age of Ultron", 2015, "Action Adventure Sci-Fi", List.of(8))));
        save(Optional.of(new Movie(15, "Black Panther", 2018, "Action Adventure Sci-Fi", List.of(13))));
        save(Optional.of(new Movie(16, "Harry Potter and the Deathly Hallows:Part 2", 2011, "Adventure Family Fantasy Mystery", List.of(14))));
        save(Optional.of(new Movie(17, "Star Wars: Episode VIII", 2017, "Action Adventure Fantasy Sci-Fi", List.of(15))));
        save(Optional.of(new Movie(18, "Jurassic World: Fallen Kingdoms", 2018, "Action Adventure Sci-Fi", List.of(16))));
        save(Optional.of(new Movie(19, "Frozen", 2013, "Adventure Animation Comedy Family Fantasy Musical", List.of(11, 12))));
        save(Optional.of(new Movie(20, "Beauty and the Beast", 2017, "Adventure Family Fantasy Musical Romance", List.of(17))));

    }

    public Optional<Movie> findById(int movieId) {
        return Optional.ofNullable(movies.get(movieId));
    }

    public Movie save(Optional<Movie> optMovie) {
        Movie movie;
        if (optMovie.isPresent()){
        movie = optMovie.get();
        }
        else{
            return null;
        }
        movies.put(movie.getId(), movie);
        return movie;
    }

    public Set<Movie> findAll() {
        return new HashSet<>(movies.values()) ;
    }

    public Movie getReferenceById(int movieId) {
        return null;
    }

    public boolean delete(int id) {
        try{
            movies.remove(id);
            return true;
        }
        catch(Exception e){
            return false;
        }

    }
}
