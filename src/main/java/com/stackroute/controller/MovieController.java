package com.stackroute.controller;

import com.stackroute.domain.Movie;
/*import com.stackroute.exceptions.DatabaseTemporarilyUnavailableException;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.exceptions.MovieDoesNotExistException;*/
import com.stackroute.exceptions.DatabaseTemporarilyUnavailableException;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.exceptions.MovieDoesNotExistException;
import com.stackroute.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class MovieController {

    @Autowired
    @Qualifier("movieDummyService")
    private MovieService movieService;

    private MovieService movieService2;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
        this.movieService2 = movieService;
    }

    @PostMapping("movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie) throws MovieAlreadyExistsException {
            movieService2.saveMovie(movie);
            return new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);
    }

    @GetMapping("movie")
    public ResponseEntity<?> getAllMovies() throws DatabaseTemporarilyUnavailableException {
            return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @PutMapping("movie")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie) throws MovieDoesNotExistException {
            movieService2.updateMovie(movie);
            return new ResponseEntity<String>("Successfully Updated", HttpStatus.OK);
    }

    @DeleteMapping("movie")
    public ResponseEntity<?> deleteMovie(@RequestBody int movieId) throws  MovieDoesNotExistException {
            movieService.deleteMovie(movieId);
            return new ResponseEntity<String>("Successfully Deleted", HttpStatus.OK);
    }

    @GetMapping("searchmovie")
    public ResponseEntity<?> getMovieByTitle(@RequestBody String title) throws MovieDoesNotExistException {
            return new ResponseEntity<List<Movie>>(movieService.findByTitle(title), HttpStatus.OK);
    }
}
