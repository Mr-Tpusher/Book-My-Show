package com.tpusher.bms.controller.admin;

import com.tpusher.bms.dto.request.RegisterShowRequest;
import com.tpusher.bms.dto.response.GenericBmsResponse;
import com.tpusher.bms.dto.response.RegisterMovieResponse;
import com.tpusher.bms.dto.response.RegisterShowResponse;
import com.tpusher.bms.entity.Show;
import com.tpusher.bms.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/shows")
    public ResponseEntity<GenericBmsResponse> registerShow(@RequestBody RegisterShowRequest request) {

        Show show = showService.registerShow(request);

        RegisterShowResponse response = new RegisterShowResponse(
                show.getHall().getName(),
                show.getMovie().getName(),
                show.getStartTime(),
                show.getEndTime());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new GenericBmsResponse(
                        "success",
                        "show successfully registered",
                        response
                ));
    }

}
