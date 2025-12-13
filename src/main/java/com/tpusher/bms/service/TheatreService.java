package com.tpusher.bms.service;

import com.tpusher.bms.dto.request.RegisterTheatreRequest;
import com.tpusher.bms.entity.Hall;
import com.tpusher.bms.entity.HallSeat;
import com.tpusher.bms.entity.Theatre;
import com.tpusher.bms.repository.HallRepository;
import com.tpusher.bms.repository.HallSeatRepository;
import com.tpusher.bms.repository.TheatreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private HallSeatRepository hallSeatRepository;

    private static final Logger logger = LoggerFactory.getLogger(TheatreService.class);


    public Theatre registerTheatreWithHallAndSeats(RegisterTheatreRequest request) {

        // 1. create theatre
        Theatre theatre = new Theatre(request.getName(), request.getCity());

        // 2. create hall
        request.getHalls().forEach(hallDTO -> {
                Hall hall = new Hall(hallDTO.getName(), theatre);
                theatre.addHall(hall);

            // 3. create hall seats
                hallDTO.getHallSeats().forEach(registerSeatDTO -> {
                    HallSeat hallSeat = new HallSeat(
                            registerSeatDTO.getName(),
                            registerSeatDTO.getSeatType(),
                            registerSeatDTO.getBasePrice(),
                            hall
                    );

                    hall.addSeat(hallSeat);
                });

        });

        return theatreRepository.save(theatre);
    }
}
