package com.tpusher.bms.service.strategy.payment;

import com.tpusher.bms.dto.dto.CreditCardDetails;
import com.tpusher.bms.dto.dto.UpiDetails;
import org.springframework.stereotype.Component;

@Component
public class PaymentStrategyFactory {

    public IPaymentStrategy creditCard(CreditCardDetails details) {
        return new CreditCardPaymentStrategy(details);
    }

    public IPaymentStrategy upi(UpiDetails details) {
        return new UpiPaymentStrategy(details);
    }

}
