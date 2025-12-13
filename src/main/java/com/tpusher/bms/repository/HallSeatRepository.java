package com.tpusher.bms.repository;

import com.tpusher.bms.entity.Hall;
import com.tpusher.bms.entity.HallSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HallSeatRepository extends JpaRepository<HallSeat, Long> {
    List<HallSeat> findByHallId(Long hallId);
}
