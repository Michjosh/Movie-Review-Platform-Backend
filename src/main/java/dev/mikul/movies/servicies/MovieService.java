package dev.mikul.movies.servicies;

import dev.mikul.movies.models.Movie;
import dev.mikul.movies.repositories.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
       return movieRepository.findAll();
    }

    public Optional<Movie> singleByImdb(String imdbId){
        return movieRepository.findByImdbId(imdbId);
    }
    public Optional<Movie> singleMovie(ObjectId id){
        return movieRepository.findById(id);
    }
}
