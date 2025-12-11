package com.tpusher.bms.entity;

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
    private String name;
    private boolean isDamaged;

    @ManyToOne
    @JoinColumn(name = "\"hall_id\"")
    private Hall hall;
}
