package com.tpusher.bms.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterMovieResponse {
    private long id;
    private String name;
}
