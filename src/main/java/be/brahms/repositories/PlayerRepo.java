package be.brahms.repositories;

import be.brahms.models.entities.PlayerEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepo extends JpaRepository<PlayerEnt, Long> {
}
