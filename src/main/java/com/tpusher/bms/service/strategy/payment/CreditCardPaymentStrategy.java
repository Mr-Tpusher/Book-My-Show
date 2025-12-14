package com.tpusher.bms.service.strategy.payment;

import com.tpusher.bms.dto.dto.CreditCardDetails;


public class CreditCardPaymentStrategy implements IPaymentStrategy {

    private CreditCardDetails details;

    public CreditCardPaymentStrategy(CreditCardDetails details) {
        this.details = details;
    }

    @Override
    public double pay(double amount) {
        // make the payment
        return 0;
    }
}
