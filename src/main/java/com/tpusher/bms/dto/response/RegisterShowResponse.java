package com.tpusher.bms.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterShowResponse {
    private String hallName;
    private String movieName;
    private OffsetDateTime startTime;
    private OffsetDateTime endTime;
}
