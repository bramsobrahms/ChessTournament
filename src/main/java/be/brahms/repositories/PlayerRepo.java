package be.brahms.repositories;

import be.brahms.models.entities.PlayerEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepo extends JpaRepository<PlayerEnt, Long> {

    @Query("SELECT p FROM PlayerEnt p WHERE p.role = 'PLAYER'")
    List <PlayerEnt> findAllPlayers();

    @Query("SELECT p FROM PlayerEnt p WHERE p.role = 'ADMIN'")
    List <PlayerEnt> findAllAdmins();

}
