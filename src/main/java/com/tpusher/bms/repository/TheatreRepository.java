package com.tpusher.bms.repository;

import com.tpusher.bms.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, UUID> {
    Optional<Theatre> findByName(String name);
    List<Theatre> findByCity(String city);


}
