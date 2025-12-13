package com.tpusher.bms.controller.admin;

import com.tpusher.bms.dto.dto.ShowSeatDTO;
import com.tpusher.bms.dto.response.GenericBmsResponse;
import com.tpusher.bms.dto.response.ShowsResponse;
import com.tpusher.bms.entity.Show;
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

    @GetMapping
    public ResponseEntity<GenericBmsResponse> getShowsByTheatreId(@RequestParam Long theatreId) {

        List<Show> shows = showService.getShowsByTheatreId(theatreId);

        List<ShowsResponse> showsResponses = shows
                .stream()
                .map(show -> {
                    ShowsResponse showsResponse = new ShowsResponse();
                    showsResponse.setTheatreName(show.getHall().getTheatre().getName());
                    showsResponse.setHallName(show.getHall().getName());
                    showsResponse.setMovieName(show.getMovie().getName());
                    showsResponse.setStartTime(show.getStartTime());
                    showsResponse.setEndTime(show.getEndTime());

                    List<ShowSeatDTO> availableSeats =
                            show.getShowSeats()
                                    .stream()
                                    .map(showSeat -> {
                                        ShowSeatDTO showSeatDTO = new ShowSeatDTO();
                                        showSeatDTO.setSeatNumber(showSeat.getHallSeat().getName());
                                        showSeatDTO.setReserved(showSeat.getHallSeat().isDamaged());
                                        showSeatDTO.setPrice(showSeat.getPrice());
                                        return showSeatDTO;
                                    })
                                    .toList();

                    showsResponse.setSeats(availableSeats);
                    return showsResponse;
                }).toList();


        return ResponseEntity.ok(new GenericBmsResponse(
                "success",
                "shows fetched by theatre id.",
                showsResponses
        ));
    }

}
