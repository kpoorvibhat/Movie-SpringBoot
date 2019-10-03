package com.stackroute.service;

import com.stackroute.domain.Movie;
/*import com.stackroute.exceptions.DatabaseTemporarilyUnavailableException;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.exceptions.MovieDoesNotExistException;*/

import java.util.List;

public interface MovieService {

    public Movie saveMovie(Movie movie); // throws MovieAlreadyExistsException;

    public List<Movie> getAllMovies() /*throws DatabaseTemporarilyUnavailableException*/;

    public Movie updateMovie(Movie movie) /*throws MovieDoesNotExistException*/;

    public String deleteMovie(int movieId) /*throws MovieDoesNotExistException*/;

    public List<Movie> findByTitle(String title);
}
