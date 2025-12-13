package com.tpusher.bms.service;

import com.tpusher.bms.dto.dto.ShowSeatDTO;
import com.tpusher.bms.dto.request.RegisterShowRequest;
import com.tpusher.bms.dto.response.ShowsResponse;
import com.tpusher.bms.entity.Hall;
import com.tpusher.bms.entity.Movie;
import com.tpusher.bms.entity.Show;
import com.tpusher.bms.entity.ShowSeat;
import com.tpusher.bms.repository.HallRepository;
import com.tpusher.bms.repository.MovieRepository;
import com.tpusher.bms.repository.ShowRepository;
import com.tpusher.bms.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    public Show registerShow(RegisterShowRequest request) {

        Hall hallRef = hallRepository.getReferenceById(request.getHallId());
        Movie movieRef = movieRepository.getReferenceById(request.getMovieId());

        Show show = new Show(request.getStartTime(), request.getEndTime(), hallRef, movieRef);

        hallRef.getSeats().forEach(hallSeat -> {
            show.addShowSeat(new ShowSeat(show, hallSeat, hallSeat.getBasePrice()));
        });

        return showRepository.save(show);


    }

    public List<ShowsResponse> getShowsByTheatreId(long theatreId) {
       List<Show> shows = showRepository.findByTheatreId(theatreId);
       return getShowResponses(shows);
    }

    public List<ShowsResponse> getShowByMovieName(String movieName) {
        List<Show> shows = showRepository.findByMovieName(movieName);
        return getShowResponses(shows);
    }

    public List<ShowsResponse> getShowResponses(List<Show> shows) {

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


        return showsResponses;

    }
}
