package com.tpusher.bms.dto.request;
import com.tpusher.bms.dto.dto.RegisterHallDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterTheatreRequest {
    private String name;
    private String city;
    private List<RegisterHallDTO> halls;
}
