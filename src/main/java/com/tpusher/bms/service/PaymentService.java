package com.tpusher.bms.service;

import com.tpusher.bms.constant.PaymentMethod;
import com.tpusher.bms.dto.dto.PaymentDetails;
import com.tpusher.bms.exception.PaymentFailedException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public void pay(
            PaymentMethod paymentMethod,
            PaymentDetails paymentDetails,
            Double amountInPaisa
    ) throws PaymentFailedException {

        // make payment

        // if failed
        throw new PaymentFailedException("payment failed");
    }
}
