package org.factoriaf5.backend.controllers;

import org.factoriaf5.backend.persistence.Movie;
import org.factoriaf5.backend.persistence.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class MovieController {

    private MovieRepository repository;

    public MovieController(@Autowired MovieRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/hello")
    public String hello() {

        return "Hola mundo!";
    }

    @GetMapping("/movies")
    public List<MovieResponse> getMovies() {
        List<MovieResponse> movies = new ArrayList<MovieResponse>();
        List<Movie> moviesInDatabase = repository.findAll();
        for (Movie movie : moviesInDatabase) {
            movies.add(new MovieResponse(movie.getId(), movie.getTitle()));
        }
        return movies;
    }

    @PostMapping("/movies")
    public MovieResponse createMovie(@RequestBody MovieRequest request) {
        Movie movie = new Movie(request.getTitle());
        Movie savedMovie = repository.save(movie);
        return new MovieResponse(savedMovie.getId(), savedMovie.getTitle());
    }

}
