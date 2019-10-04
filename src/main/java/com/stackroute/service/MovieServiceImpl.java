package com.stackroute.service;

import com.stackroute.domain.Movie;
import com.stackroute.exceptions.DatabaseTemporarilyUnavailableException;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.exceptions.MovieDoesNotExistException;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class MovieServiceImpl implements MovieService {
    MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {

        this.movieRepository = movieRepository;
        System.out.println("Movie Service");
    }

    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
       if (movieRepository.existsById(movie.getId())) {
            throw new MovieAlreadyExistsException();
        }
        Movie savedMovie = movieRepository.save(movie);
        System.out.println("saving using movie service");
        return savedMovie;
    }

    @Override
    public List<Movie> getAllMovies() throws DatabaseTemporarilyUnavailableException {
        if (movieRepository.findAll().isEmpty()) throw new DatabaseTemporarilyUnavailableException();

        System.out.println("retrieving using movie service");
        return movieRepository.findAll();
    }

    @Override
    public Movie updateMovie(Movie movie) throws MovieDoesNotExistException {
        if (!movieRepository.existsById(movie.getId()))
            throw new MovieDoesNotExistException();
        Movie updatedMovie = movieRepository.save(movie);
        System.out.println("updating using movie service");
        return updatedMovie;
    }

    @Override
    public String deleteMovie(int movieId) throws MovieDoesNotExistException {
        if (!movieRepository.existsById(movieId)) {
            throw new MovieDoesNotExistException();
            }
        movieRepository.deleteById(movieId);
        System.out.println("deleting using movie service");
        return "Movie deleted";
    }

    @Override
    public List<Movie> findByTitle(String title) throws MovieDoesNotExistException{
        if (movieRepository.findByTitle(title) == null)
            throw new MovieDoesNotExistException();
        System.out.println("searching using movie service");
        return movieRepository.findByTitle(title);
    }
}
