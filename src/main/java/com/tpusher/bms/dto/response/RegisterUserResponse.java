package com.tpusher.bms.dto.response;

import com.tpusher.bms.constant.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserResponse {
    private UUID userId;
    private String username;
    private UserRole userRole;
}
