package be.brahms.services;

import be.brahms.models.entities.PlayerEnt;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface PlayerServ extends UserDetailsService {

    PlayerEnt create(PlayerEnt player);
    PlayerEnt findById(Long id);
    List<PlayerEnt> findAllPlayers();
    List<PlayerEnt> findAllAdmins();
    PlayerEnt update(Long id, PlayerEnt player);
    void delete(Long id);
    PlayerEnt login(PlayerEnt player);

}
