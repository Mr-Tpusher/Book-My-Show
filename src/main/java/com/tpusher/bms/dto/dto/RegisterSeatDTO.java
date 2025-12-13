package com.tpusher.bms.dto.dto;

import com.tpusher.bms.constant.SeatType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class RegisterSeatDTO {
    private String name;
    private SeatType seatType;
    private double basePrice;
}
