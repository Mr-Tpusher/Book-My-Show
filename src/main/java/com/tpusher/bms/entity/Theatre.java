package com.tpusher.bms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "theatres")
public class Theatre extends Auditable {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "city", nullable = false)
    private String city;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Hall> halls = new ArrayList<>();


    public Theatre(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public void addHall(Hall hall) {
        halls.add(hall);
        hall.setTheatre(this);
    }

}
