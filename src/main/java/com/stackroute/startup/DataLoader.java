package com.stackroute.startup;

import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import com.stackroute.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private MovieRepository movieRepository;
    private MovieService movieService;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void run(String... args) throws Exception {
        movieRepository.save(new Movie(3, "Bahubali", false, "action"));
        movieRepository.save(new Movie(4, "Frozen", false, "animated"));
    }
}
