package com.tpusher.bms.repository;

import com.tpusher.bms.entity.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {
    List<Hall> findByTheatreId(Long theatreId);

}
