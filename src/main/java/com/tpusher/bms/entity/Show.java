package com.tpusher.bms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shows")
public class Show extends Auditable {

    private OffsetDateTime startTime;

    private OffsetDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "\"hall_id\"")
    private Hall hall;

    @ManyToOne
    @JoinColumn(name = "\"movie_id\"")
    private Movie movie;

    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeats;

}
