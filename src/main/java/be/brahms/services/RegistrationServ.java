package be.brahms.services;

import be.brahms.models.entities.RegistrationEnt;

public interface RegistrationServ {

    RegistrationEnt registre(Long userId,Long tournamentId);

}
