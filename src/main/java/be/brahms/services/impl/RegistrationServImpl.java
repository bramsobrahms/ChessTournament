package be.brahms.services.impl;


import be.brahms.enums.Gender;
import be.brahms.enums.Status;
import be.brahms.exceptions.player.NotFoundPlayerException;
import be.brahms.exceptions.tournament.NotFoundTournamentException;
import be.brahms.models.entities.PlayerEnt;
import be.brahms.models.entities.RegistrationEnt;
import be.brahms.models.entities.TournamentEnt;
import be.brahms.repositories.PlayerRepo;
import be.brahms.repositories.RegistrationRepo;
import be.brahms.repositories.TournamentRepo;
import be.brahms.services.RegistrationServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


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
        PlayerEnt player = playerRepo.findById(userId).orElseThrow(NotFoundPlayerException::new);
        TournamentEnt tournament = tournamentRepo.findById(tournamentId).orElseThrow(NotFoundTournamentException::new);
        RegistrationEnt regisration = new RegistrationEnt(player,tournament);

        if (tournament.getStatus().equals(Status.WAITING)){

            LocalDate dateNow = LocalDate.now();

            int currentCountPlayer = registrationRepo.countOfTournamentById(tournamentId);

            if( tournament.isWomenOnly() && !player.getGender().equals(Gender.FEMALE)){
                System.out.println("This is reserved only women");
                return regisration;
            }

            if(dateNow.isBefore(tournament.getEndDateAt()) && currentCountPlayer <= tournament.getMaxPlayer() && (player.getElo() <= tournament.getMaxElo() && player.getElo() >= tournament.getMinElo()) ){
                regisration.setRegistred(true);
                registrationRepo.save(regisration);
                return regisration;
            } else{
                return regisration;
            }

        }

        return regisration;

    }

}