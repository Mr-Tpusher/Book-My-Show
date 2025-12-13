package com.tpusher.bms.repository;

import com.tpusher.bms.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findByHallId(Long hallId);

    List<Show> findByMovieId(Long movieId);

    @Query(value =
            " select s.* from shows s " +
                    "join halls h on s.hall_id = h.id " +
                    "join theatres t on h.theatre_id = t.id " +
                    "where t.id = :theatre_id;",
            nativeQuery = true)
    List<Show> findByTheatreId(@Param("theatre_id") Long theatreId);
}
