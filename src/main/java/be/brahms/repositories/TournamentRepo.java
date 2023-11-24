package be.brahms.repositories;

import be.brahms.models.entities.TournamentEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentRepo extends JpaRepository<TournamentEnt, Long> {

    @Query("SELECT t FROM TournamentEnt t WHERE t.womenOnly = true")
    List<TournamentEnt> findAllTournamentOnlyWoment();

    @Query("SELECT t FROM TournamentEnt t WHERE LOWER(t.name) LIKE LOWER(CONCAT('%', :searchData, '%')) OR LOWER(t.place) LIKE LOWER(CONCAT('%', :searchData, '%')) OR LOWER(t.category) LIKE LOWER(CONCAT('%', :searchData, '%')) OR LOWER(t.status) LIKE LOWER(CONCAT('%', :searchData, '%')) ")
    List<TournamentEnt> searchByData(@Param("searchData") String searchData);

}
