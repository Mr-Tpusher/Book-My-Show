package com.tpusher.bms.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterMovieRequest {
    private String name;
    private int durationInMinutes;
}
