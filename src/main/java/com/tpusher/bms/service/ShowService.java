package com.tpusher.bms.service;

import com.tpusher.bms.dto.request.RegisterShowRequest;
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

    public List<Show> getShowsByTheatreId(long theatreId) {
       return showRepository.findByTheatreId(theatreId);
    }
}
