package be.brahms.repositories;

import be.brahms.models.entities.PlayerEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepo extends JpaRepository<PlayerEnt, Long> {

    @Query("SELECT p FROM PlayerEnt p WHERE p.role = 'PLAYER'")
    List <PlayerEnt> findAllPlayers();

    @Query("SELECT p FROM PlayerEnt p WHERE p.role = 'ADMIN'")
    List <PlayerEnt> findAllAdmins();

    @Query("SELECT p FROM PlayerEnt p WHERE p.email = :email OR p.pseudo = :pseudo")
    Optional<PlayerEnt> findEmailOrPseudo(@Param("email") String email, @Param("pseudo") String pseudo);

//    Optional<PlayerEnt> findByEmail(String email);

}
