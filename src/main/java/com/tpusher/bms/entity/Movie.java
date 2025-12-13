package com.tpusher.bms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movie extends Auditable {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "duration_in_minutes", nullable = false)
    private int durationInMinutes;
}
