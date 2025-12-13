package com.tpusher.bms.service;

import com.tpusher.bms.dto.request.RegisterMovieRequest;
import com.tpusher.bms.entity.Movie;
import com.tpusher.bms.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie registerMovie(RegisterMovieRequest request) {

        return movieRepository.save(
                new Movie(
                        request.getName(),
                        request.getDurationInMinutes()
                )
        );
    }
}
