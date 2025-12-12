package com.tpusher.bms.entity;

import com.tpusher.bms.constant.UserRole;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends Auditable {

    @Column(name = "\"username\"")
    private String username;

    @Column(name = "\"hashed_password\"")
    private String hashedPassword;


    @Column(name = "\"user_role\"")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}
