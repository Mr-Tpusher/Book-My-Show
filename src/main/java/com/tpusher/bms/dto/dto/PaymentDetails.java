package com.tpusher.bms.dto.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
        property = "paymentMethod"
)

@JsonSubTypes(
        {
                @JsonSubTypes.Type(value = CreditCardDetails.class, name = "CREDIT_CARD"),
                @JsonSubTypes.Type(value = UpiDetails.class, name = "UPI")
        }
)
public interface PaymentDetails {
}
