package com.stackroute.service;

import com.stackroute.domain.Movie;
import com.stackroute.exceptions.DatabaseTemporarilyUnavailableException;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.exceptions.MovieDoesNotExistException;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile(value="main")
public class MovieServiceImpl implements MovieService {
    MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {

        this.movieRepository = movieRepository;
        System.out.println("Movie Service");
    }

    //This method saves a new movie to the database
    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
       if (movieRepository.existsById(movie.getId())) {
            throw new MovieAlreadyExistsException();
        }
        Movie savedMovie = movieRepository.save(movie);
        System.out.println("saving using movie service");
        return savedMovie;
    }

    //This method retrieves all the movies from the database
    @Override
    public List<Movie> getAllMovies() throws DatabaseTemporarilyUnavailableException {
        if (movieRepository.findAll().isEmpty()) throw new DatabaseTemporarilyUnavailableException();

        System.out.println("retrieving using movie service");
        return movieRepository.findAll();
    }

    //This method updates the movie details
    @Override
    public Movie updateMovie(Movie movie) throws MovieDoesNotExistException {
        if (!movieRepository.existsById(movie.getId()))
            throw new MovieDoesNotExistException();
        Movie updatedMovie = movieRepository.save(movie);
        System.out.println("updating using movie service");
        return updatedMovie;
    }

    //This method deletes the movie by Id from the database
    @Override
    public String deleteMovie(int movieId) throws MovieDoesNotExistException {
        if (!movieRepository.existsById(movieId)) {
            throw new MovieDoesNotExistException();
            }
        movieRepository.deleteById(movieId);
        System.out.println("deleting using movie service");
        return "Movie deleted";
    }

    //This method searches for the movie service by its name
    @Override
    public List<Movie> findByTitle(String title) throws MovieDoesNotExistException{
        if (movieRepository.findByTitle(title) == null)
            throw new MovieDoesNotExistException();
        System.out.println("searching using movie service");
        return movieRepository.findByTitle(title);
    }
}
