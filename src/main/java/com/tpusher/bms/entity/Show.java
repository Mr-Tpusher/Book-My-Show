package com.tpusher.bms.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shows")
public class Show extends Auditable {

    @Column(name = "start_time", nullable = false)
    private OffsetDateTime startTime;

    @Column(name = "end_time")
    private OffsetDateTime endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<ShowSeat> showSeats = new ArrayList<>();

    public Show(OffsetDateTime startTime, OffsetDateTime endTime, Hall hall, Movie movie) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.hall = hall;
        this.movie = movie;
    }

    public void addShowSeat(ShowSeat showSeat) {
        this.showSeats.add(showSeat);
        showSeat.setShow(this);
    }
}
