package com.tpusher.bms.service;

import com.tpusher.bms.dto.request.PaymentRequest;
import com.tpusher.bms.dto.request.ReserveShowSeatsRequest;
import com.tpusher.bms.repository.BookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;


    @Transactional
    public void reserveSeats(ReserveShowSeatsRequest request) {
        // 1. check if the seats are available
            // if not throw an exception

        // 2. reserve if available

        // 3. create a booking

        // 4. return the booking

    }

    public void pay(Long bookingId, PaymentRequest paymentRequest) {

        // 1. check if seats are still available

        // 2. make payment

        // 3. update seats to reserved

        // 4. update booking

        // 5. create ticket

        // 6. return ticket

    }
}
