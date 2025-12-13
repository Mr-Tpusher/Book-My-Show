package com.tpusher.bms.controller;

import com.tpusher.bms.dto.response.TheatreResponse;
import com.tpusher.bms.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @GetMapping
    public ResponseEntity<List<TheatreResponse>> getTheatresByCity(@RequestParam String city) {

        List<TheatreResponse> theatreList = theatreService.getTheatresByCity(city)
                .stream()
                .map(theatre -> new TheatreResponse(theatre.getId(), theatre.getName()))
                .toList();

        return ResponseEntity.ok(theatreList);
    }

}
