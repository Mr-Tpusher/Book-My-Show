package com.tpusher.bms.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "halls")
public class Hall extends Auditable {

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
    private List<Show> shows = new ArrayList<>();

    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
    private List<HallSeat> seats = new ArrayList<>();

    public Hall(String name, Theatre theatre) {
        this.name = name;
        this.theatre = theatre;
    }

    public void addSeat(HallSeat hallSeat) {
        seats.add(hallSeat);
        hallSeat.setHall(this);
    }

    public void addShow(Show show) {
        shows.add(show);
        show.setHall(this);
    }

}
