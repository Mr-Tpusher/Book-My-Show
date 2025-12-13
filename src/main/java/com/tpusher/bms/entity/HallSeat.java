package com.tpusher.bms.entity;

import com.tpusher.bms.constant.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hall_seats")
public class HallSeat extends Auditable {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "is_damaged")
    private boolean isDamaged;

    @Column(name = "seat_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @Column(name = "base_price")
    private double basePrice;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    public HallSeat(String name, SeatType seatType, double basePrice, Hall hall) {
        this.name = name;
        this.seatType = seatType;
        this.basePrice = basePrice;
        this.hall = hall;
    }
}
