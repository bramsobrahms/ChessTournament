package be.brahms.services;

import be.brahms.models.entities.PlayerEnt;

import java.util.List;

public interface PlayerServ {

    PlayerEnt create(PlayerEnt player);
    PlayerEnt findById(Long id);
    List<PlayerEnt> findAllPlayers();
    List<PlayerEnt> findAllAdmins();
    PlayerEnt update(Long id, PlayerEnt player);
    void delete(Long id);

}
