package com.tpusher.bms.controller;

import com.tpusher.bms.dto.request.PaymentRequest;
import com.tpusher.bms.dto.request.ReserveShowSeatsRequest;
import com.tpusher.bms.dto.response.GenericBmsResponse;
import com.tpusher.bms.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;

    // reserve seats
    @PostMapping
    public ResponseEntity<GenericBmsResponse> reserveSeats(@RequestBody ReserveShowSeatsRequest request) {

        bookingService.reserveSeats(request);

        return null;
    }

    // make payment
    @PostMapping("/{bookingId}/payment")
    public ResponseEntity<GenericBmsResponse> pay(
            @PathVariable Long bookingId,
            @RequestBody PaymentRequest paymentRequest
            ) {

        bookingService.pay(bookingId, paymentRequest);

        return null;
    }
}
