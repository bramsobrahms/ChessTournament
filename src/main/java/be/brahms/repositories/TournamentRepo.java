package be.brahms.repositories;

import be.brahms.models.entities.TournamentEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepo extends JpaRepository<TournamentEnt, Long> {
}
