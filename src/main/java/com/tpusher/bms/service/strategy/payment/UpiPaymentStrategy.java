package com.tpusher.bms.service.strategy.payment;

import com.tpusher.bms.dto.dto.UpiDetails;

public class UpiPaymentStrategy implements IPaymentStrategy {

    private UpiDetails upiDetails;

    public UpiPaymentStrategy(UpiDetails details) {
    }

    @Override
    public double pay(double amount) {
        return 0;
    }
}
