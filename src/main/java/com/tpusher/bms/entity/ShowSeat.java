package com.tpusher.bms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"show_seats\"")
public class ShowSeat extends Auditable {

    @ManyToOne
    @JoinColumn(name = "\"show_id\"")
    private Show show;

    @ManyToOne
    @JoinColumn(name = "\"hall_seat_id\"")
    private HallSeat hallSeat;

    @ManyToOne
    @JoinColumn(name = "\"booking_id\"")
    private Booking booking;

    private boolean isReserved;
}
