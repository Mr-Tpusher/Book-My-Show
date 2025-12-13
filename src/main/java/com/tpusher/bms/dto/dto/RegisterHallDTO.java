package com.tpusher.bms.dto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class RegisterHallDTO {
    private String name;
    private List<RegisterSeatDTO> hallSeats;
}
