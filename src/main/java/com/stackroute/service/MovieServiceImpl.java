package com.stackroute.service;

import com.stackroute.domain.Movie;
/*import com.stackroute.exceptions.DatabaseTemporarilyUnavailableException;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.exceptions.MovieDoesNotExistException;*/
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) /*throws MovieAlreadyExistsException */{
      /*  if (movieRepository.existsById(movie.getId())) {
            throw new MovieAlreadyExistsException("Movie Already Exists");
        }*/
        Movie savedMovie = movieRepository.save(movie);

        return savedMovie;
    }

    @Override
    public List<Movie> getAllMovies()/* throws DatabaseTemporarilyUnavailableException */{
       /* if (movieRepository.findAll() == null) throw new DatabaseTemporarilyUnavailableException("Database Temporarily Unavailable");*/
        return movieRepository.findAll();
    }

    @Override
    public Movie updateMovie(Movie movie) /*throws MovieDoesNotExistException*/ {
      /*  if (movieRepository.existsById(movie.getId()))
            throw new MovieDoesNotExistException("Movie Not Found");*/
        Movie updatedMovie = movieRepository.save(movie);
        return updatedMovie;
    }

    @Override
    public String deleteMovie(int movieId) /*throws MovieDoesNotExistException*/ {
//        if (!movieRepository.existsById(movieId)) {
//            throw new MovieDoesNotExistException("Movie Does Not Exist");
//        }
        movieRepository.deleteById(movieId);
        return "Movie deleted";
    }

    @Override
    public Movie findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }
}
