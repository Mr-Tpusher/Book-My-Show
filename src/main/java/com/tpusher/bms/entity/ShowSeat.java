package com.tpusher.bms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "show_seats")
public class ShowSeat extends Auditable {

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    @ManyToOne
    @JoinColumn(name = "hall_seat_id")
    private HallSeat hallSeat;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Column(name = "is_reserved")
    private boolean isReserved;

    public ShowSeat(Show show, HallSeat hallSeat) {
        this.show = show;
        this.hallSeat = hallSeat;
    }
}
