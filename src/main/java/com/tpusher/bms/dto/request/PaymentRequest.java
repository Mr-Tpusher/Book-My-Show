package com.tpusher.bms.dto.request;

import com.tpusher.bms.constant.PaymentMethod;
import com.tpusher.bms.dto.dto.PaymentDetails;
import lombok.Data;

@Data
public class PaymentRequest {
    private Double amountInRupees;
    private PaymentMethod paymentMethod;
    private PaymentDetails paymentDetails;
}
