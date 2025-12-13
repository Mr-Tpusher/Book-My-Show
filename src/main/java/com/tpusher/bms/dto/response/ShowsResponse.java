package com.tpusher.bms.dto.response;

import com.tpusher.bms.dto.dto.ShowSeatDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class ShowsResponse {
    private String theatreName;
    private String hallName;
    private String movieName;
    private OffsetDateTime startTime;
    private OffsetDateTime endTime;
    private List<ShowSeatDTO> seats;
}
