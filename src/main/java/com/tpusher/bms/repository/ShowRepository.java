package com.tpusher.bms.repository;
import com.tpusher.bms.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface ShowRepository extends JpaRepository<Show, UUID> {
    List<Show> findByHallId(UUID hallId);
    List<Show> findByMovieId(UUID movieId);
}
