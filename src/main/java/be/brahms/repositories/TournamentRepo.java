package be.brahms.repositories;

import be.brahms.models.entities.TournamentEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentRepo extends JpaRepository<TournamentEnt, Long> {

    @Query("SELECT t FROM TournamentEnt t WHERE t.womenOnly = true")
    List<TournamentEnt> findAllTournamentOnlyWoment();
}
