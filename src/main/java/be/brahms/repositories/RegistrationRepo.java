package be.brahms.repositories;

import be.brahms.models.entities.RegistrationEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepo extends JpaRepository<RegistrationEnt, Long> {

    @Query("SELECT COUNT(r) FROM RegistrationEnt r WHERE r.tournament.id = :tournamentId ")
    int countOfTournamentById(@Param("tournamentId") Long tournamentId);


}
