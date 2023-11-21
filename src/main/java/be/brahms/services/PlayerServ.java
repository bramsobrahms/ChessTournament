package be.brahms.services;

import be.brahms.models.entities.PlayerEnt;

public interface PlayerServ {

    PlayerEnt create(PlayerEnt player);
    PlayerEnt findById(Long id);

}
