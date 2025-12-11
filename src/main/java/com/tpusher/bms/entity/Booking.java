package com.tpusher.bms.entity;

import com.tpusher.bms.constant.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking extends Auditable {

    @ManyToOne
    @JoinColumn(name = "\"user_id\"")
    private User user;

    @ManyToOne
    @JoinColumn(name = "\"show_id\"")
    private Show show;

    @OneToMany(mappedBy = "booking")
    private List<ShowSeat> bookedShowSeats;

    @Column(name = "\"booking_status\"")
    private BookingStatus bookingStatus;

    @Column(name = "\"totalAmount\"")
    private double totalAmount;

}
