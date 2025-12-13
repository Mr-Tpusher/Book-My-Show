package com.tpusher.bms.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class RegisterShowRequest {
    private long hallId;
    private long movieId;
    private OffsetDateTime startTime;
    private OffsetDateTime endTime;
}
