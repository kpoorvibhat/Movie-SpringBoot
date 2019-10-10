package com.stackroute.service;

import com.stackroute.domain.Movie;
import com.stackroute.exceptions.DatabaseTemporarilyUnavailableException;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.exceptions.MovieDoesNotExistException;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Profile("dummy")
public class MovieDummyService implements MovieService {
    MovieRepository movieRepository;

    @Autowired
    public MovieDummyService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
        System.out.println("Dummy Service");
    }

    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
        if (movieRepository.existsById(movie.getId())) {
            throw new MovieAlreadyExistsException();
        }
        Movie savedMovie = movieRepository.save(movie);
        System.out.println("saving using Dummy Service");
        return savedMovie;
    }

    @Override
    public List<Movie> getAllMovies() throws DatabaseTemporarilyUnavailableException {
        if (movieRepository.findAll().isEmpty()) throw new DatabaseTemporarilyUnavailableException();
        System.out.println("fetching movie using Dummy Service");
        return movieRepository.findAll();
    }

    @Override
    public Movie updateMovie(Movie movie) throws MovieDoesNotExistException {
        if (!movieRepository.existsById(movie.getId()))
            throw new MovieDoesNotExistException();
        Movie updatedMovie = movieRepository.save(movie);
        System.out.println("updating using Dummy Service");
        return updatedMovie;
    }

    @Override
    public String deleteMovie(int movieId) throws MovieDoesNotExistException {
        if (!movieRepository.existsById(movieId)) {
            throw new MovieDoesNotExistException();
        }
        movieRepository.deleteById(movieId);
        System.out.println("searching using Dummy Service");
        return "Movie deleted";
    }

    @Override
    public List<Movie> findByTitle(String title) throws MovieDoesNotExistException{
        if (movieRepository.findByTitle(title) == null)
            throw new MovieDoesNotExistException();
        return movieRepository.findByTitle(title);
    }
}
