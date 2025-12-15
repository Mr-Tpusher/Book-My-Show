package com.tpusher.bms.controller;

import com.tpusher.bms.dto.response.GenericBmsResponse;
import com.tpusher.bms.dto.response.ShowsResponse;
import com.tpusher.bms.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping(params = "theatreId")
    public ResponseEntity<GenericBmsResponse> getShowsByTheatreId(@RequestParam Long theatreId) {

        List<ShowsResponse> showsResponses = showService.getShowsByTheatreId(theatreId);


        return ResponseEntity.ok(new GenericBmsResponse(
                "success",
                "shows fetched by theatre id.",
                showsResponses
        ));
    }


    @GetMapping(params = "movieName")
    public ResponseEntity<GenericBmsResponse> getShowsByMovieName(@RequestParam String movieName) {

        List<ShowsResponse> showsResponses = showService.getShowByMovieName(movieName);


        return ResponseEntity.ok(new GenericBmsResponse(
                "success",
                "shows fetched by movie id.",
                showsResponses
        ));
    }

}
