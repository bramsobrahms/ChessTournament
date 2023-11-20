package be.brahms.repositories;

import be.brahms.models.entities.PlayerTournamentEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerTournamentRepo extends JpaRepository<PlayerTournamentEnt, Long> {
}
