package com.stackroute.startup;

import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import com.stackroute.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
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
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadMovies();
    }

    public void loadMovies(){
        Movie movie1 = new Movie(1, "Chhichore", false, "comedy");
        movieRepository.save(movie1);

        Movie movie2 = new Movie(2, "Joker", true, "drama");
        movieRepository.save(movie2);
    }
}
