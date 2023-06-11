package dev.mikul.movies.controllers;


import dev.mikul.movies.models.Movie;
import dev.mikul.movies.servicies.MovieService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3001", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3001");
        return new ResponseEntity<>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String id, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3001");
        return new ResponseEntity<>(movieService.singleByImdb(id), HttpStatus.OK);
    }
}
