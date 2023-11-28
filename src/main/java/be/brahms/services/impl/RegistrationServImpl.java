package be.brahms.services.impl;


import be.brahms.models.entities.PlayerEnt;
import be.brahms.models.entities.RegistrationEnt;
import be.brahms.models.entities.TournamentEnt;
import be.brahms.repositories.PlayerRepo;
import be.brahms.repositories.RegistrationRepo;
import be.brahms.repositories.TournamentRepo;
import be.brahms.services.RegistrationServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegistrationServImpl implements RegistrationServ {

    private final RegistrationRepo registrationRepo;
    private final PlayerRepo playerRepo;
    private final TournamentRepo tournamentRepo;

    @Autowired
    public RegistrationServImpl(RegistrationRepo registrationRepo, PlayerRepo playerRepo, TournamentRepo tournamentRepo) {
        this.registrationRepo = registrationRepo;
        this.playerRepo = playerRepo;
        this.tournamentRepo = tournamentRepo;
    }

    @Override
    public RegistrationEnt registre(Long userId, Long tournamentId) {
        PlayerEnt p = playerRepo.findById(userId).orElseThrow();
        TournamentEnt t = tournamentRepo.findById(tournamentId).orElseThrow();

        RegistrationEnt regisration = new RegistrationEnt(p,t);

        registrationRepo.save(regisration);


        return regisration;
    }

}
