package com.tpusher.bms.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GenericBmsResponse {
    private String status;
    private String message;
    private Object payload;
}
