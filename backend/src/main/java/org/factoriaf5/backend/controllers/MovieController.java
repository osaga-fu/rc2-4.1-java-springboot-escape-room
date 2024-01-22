package org.factoriaf5.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class MovieController {
    
    @GetMapping("/hello")
    public String hello() {

        return "Hola mundo!";
    }

    @GetMapping("/movies")
    public List<MovieResponse> getMovies( String title, Long id){
        return List.of( new MovieResponse( title, id));
    }

    @PostMapping("/movies")
    public void createMovie(@RequestBody MovieRequest movie){
        System.out.println("Recibida, película");
        System.out.println(movie.whichMovie());
    }
}
