package com.tpusher.bms.controller.admin;

import com.tpusher.bms.dto.request.RegisterTheatreRequest;
import com.tpusher.bms.dto.response.GenericBmsResponse;
import com.tpusher.bms.dto.response.RegisterTheatreResponse;
import com.tpusher.bms.entity.Theatre;
import com.tpusher.bms.service.TheatreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminTheatreController {

    @Autowired
    private TheatreService theatreService;

    private static final Logger logger = LoggerFactory.getLogger(AdminTheatreController.class);

    @PostMapping("/theatre")
    public ResponseEntity<GenericBmsResponse> registerTheatre(@RequestBody RegisterTheatreRequest request) {
        logger.debug("RegisterTheatreRequest = {}", request);

        Theatre theatre = theatreService.registerTheatreWithHallAndSeats(request);

        return new ResponseEntity<>(
                new GenericBmsResponse(
                        "success",
                        "theatre successfully registered.",
                        new RegisterTheatreResponse(theatre.getId(), theatre.getName())
                ), HttpStatus.CREATED
        );
    }
}
