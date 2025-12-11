package com.tpusher.bms.entity;

import com.tpusher.bms.constant.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
    private UserRole userRole;
}
