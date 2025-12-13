package com.tpusher.bms.controller.admin;

import com.tpusher.bms.dto.request.RegisterMovieRequest;
import com.tpusher.bms.dto.response.GenericBmsResponse;
import com.tpusher.bms.dto.response.RegisterMovieResponse;
import com.tpusher.bms.entity.Movie;
import com.tpusher.bms.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminMovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/movies")
    public ResponseEntity<GenericBmsResponse> registerMovie(@RequestBody RegisterMovieRequest request) {
        Movie movie = movieService.registerMovie(request);

        RegisterMovieResponse response = new RegisterMovieResponse(movie.getId(), movie.getName());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        new GenericBmsResponse(
                                "success",
                                "movie successfully added",
                                response
                        )
                );
    }
}
