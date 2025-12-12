package com.tpusher.bms.dto.request;
import com.tpusher.bms.constant.UserRole;
import lombok.Data;
import lombok.ToString;

@Data
public class RegisterUserRequest {
    private String username;
    private String password;
    private UserRole userRole;
}
