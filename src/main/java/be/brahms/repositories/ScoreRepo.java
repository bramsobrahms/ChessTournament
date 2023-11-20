package be.brahms.repositories;

import be.brahms.models.entities.ScoreEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepo extends JpaRepository<ScoreEnt, Long> {
}
