package com.tpusher.bms.dto.request;

import java.util.List;

public class ReserveShowSeatsRequest {
    private Long userId;
    private Long showId;
    private List<String> seatNumbers;
}
