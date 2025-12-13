package com.tpusher.bms.dto.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShowSeatDTO {
    private String seatNumber;
    private boolean isReserved;
    private double price;
}
