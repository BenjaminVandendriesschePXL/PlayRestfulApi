package controllers;

import Utils.Util;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Singleton;
import domain.Movie;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;
import play.mvc.Result;
import repository.MovieRepository;
import service.MovieService;
import service.impl.MovieServiceImpl;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletionStage;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import static play.mvc.Results.*;

@Singleton
public class MovieController {
    private final MovieRepository movieRepository;
    private final HttpExecutionContext ec;
    private final MovieServiceImpl movieService;

    @Inject
    public MovieController(HttpExecutionContext ec, MovieRepository movieRepository) {
        this.ec = ec;
        this.movieRepository = movieRepository;
        movieService = new MovieServiceImpl(movieRepository);
    }

//    public List<Movie> findAllMovies(){
//        return movieService.findAllMovies();
//    }

//    public MovieDTO getMovieById( Long movieId){
//        return movieService.findMovieById(movieId);
//    }
//

    public CompletionStage<Result> listStudents() {
        return supplyAsync(() -> {
            Set<Movie> result = movieRepository.findAll();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonData = mapper.convertValue(result, JsonNode.class);
            return ok(Util.createResponse(jsonData, true));
        }, ec.current());
    }

    public CompletionStage<Result> create(Http.Request request) {
        JsonNode json = request.body().asJson();
        //System.out.println(request.body().asText());
        return supplyAsync(() -> {
            if (json == null) {
                return badRequest(Util.createResponse("Expecting Json data", false));
            }
            Optional<Movie> movieOptional = movieService.createMovie(Json.fromJson(json, MovieRequest.class));
            return movieOptional.map(student -> {
                JsonNode jsonObject = Json.toJson(student);
                movieRepository.save(movieOptional);
               return created(Util.createResponse(jsonObject, true));
            }).orElse(internalServerError(Util.createResponse("Could not create data.", false)));
        }, ec.current());
        }

//    public MovieDTO updateMovie( Long movieId, MovieRequest movieRequest) {
//        return movieService.updateMovie(movieId, movieRequest);
//    }
    public Movie update(MovieRequest request) {
        Optional<Movie> movieOptional = movieService.updateMovie(request.getId(), request);
        return movieOptional.stream().findFirst().orElse(null);
}

//public CompletionStage<Result> update(Http.Request request) {
//    JsonNode json = request.body().asJson();
//    return supplyAsync(() -> {
//        if (json == null) {
//            return badRequest(Util.createResponse("Expecting Json data", false));
//        }
//        MovieRequest fromJson = Json.fromJson(json, MovieRequest.class);
//        Optional<Movie> movieOptional = movieService.updateMovie(fromJson.getId(),fromJson);
//        return movieOptional.map(movie -> {
//            if (movie == null) {
//                return notFound(Util.createResponse("Movie not found", false));
//            }
//            JsonNode jsonObject = Json.toJson(movie);
//            movieRepository.save(movieOptional);
//            return ok(Util.createResponse(jsonObject, true));
//        }).orElse(internalServerError(Util.createResponse("Could not create data.", false)));
//    }, ec.current());
//}

    public CompletionStage<Result> retrieve(int id) {
        return supplyAsync(() -> {
            final Optional<Movie> studentOptional = movieRepository.findById(id);
            return studentOptional.map(movie -> {
                JsonNode jsonObjects = Json.toJson(movie);
                return ok(Util.createResponse(jsonObjects, true));
            }).orElse(notFound(Util.createResponse("Movie with id:" + id + " not found", false)));
        }, ec.current());
    }

    public CompletionStage<Result> delete(int id) {
        return supplyAsync(() -> {
            boolean status = movieRepository.delete(id);
            if (!status) {
                return notFound(Util.createResponse("Movie with id:" + id + " not found", false));
            }
            return ok(Util.createResponse("Movie with id:" + id + " deleted", true));
        }, ec.current());
    }
//    public void deleteMovie( Long movieId) {boolean deleted = movieService.deleteMovie(movieId);
//        }
}

