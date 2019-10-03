package com.stackroute.controller;

import com.stackroute.domain.Movie;
/*import com.stackroute.exceptions.DatabaseTemporarilyUnavailableException;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.exceptions.MovieDoesNotExistException;*/
import com.stackroute.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
        try {
            movieService.saveMovie(movie);
            return new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);
        }
        catch (/*MovieAlreadyExists*/Exception ex) {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("movie")
    public ResponseEntity<?> getAllMovies(){
        try {
            return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
        }
        catch (/*DatabaseTemporarilyUnavailable*/Exception ex) {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("movie")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie) {
        try {
            movieService.updateMovie(movie);
            return new ResponseEntity<String>("Successfully Updated", HttpStatus.OK);
        }
        catch (/*MovieDoesNotExist*/Exception ex) {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("movie")
    public ResponseEntity<?> deleteMovie(@RequestBody int movieId) {
        try {
            movieService.deleteMovie(movieId);
            return new ResponseEntity<String>("Successfully Deleted", HttpStatus.OK);
        }
        catch (/*MovieDoesNotExist*/Exception ex) {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
