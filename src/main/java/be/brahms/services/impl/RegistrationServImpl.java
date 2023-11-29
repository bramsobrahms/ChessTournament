package be.brahms.services.impl;


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
import java.util.Collections;
import java.util.List;


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

        while (tournament.getStatus().equals(Status.WAITING)){

            LocalDate dateNow = LocalDate.now();
            LocalDate dateEnd = tournament.getEndDateAt();

            //dateNow.isBefore() est aussi valable pour comparer les dates
            int dateCompare = dateEnd.compareTo(dateNow);
            int maxPlayer = tournament.getMaxPlayer();
            int currentCountPlayer = registrationRepo.countOfTournamentById(tournamentId);

            int minEloTour = tournament.getMinElo();
            int maxEloTour = tournament.getMaxElo();
            int eloPlay = player.getElo();

            if(dateCompare>=0 && currentCountPlayer <= maxPlayer && (eloPlay <= maxEloTour && eloPlay >= minEloTour) ){
                regisration.setRegistred(true);
                //delete from here
                System.out.println("you registered");
                System.out.println(maxPlayer);
                System.out.println(currentCountPlayer);
                System.out.println("playerElo_"+eloPlay);
                System.out.println("minElo"+minEloTour);
                System.out.println("maxElo_"+maxEloTour);
                // to here
                registrationRepo.save(regisration);
                return regisration;

            } else{
                //delete from here
                System.out.println("The registration date has passed or the number of players has reached its maximum capacity.");
                System.out.println(maxPlayer);
                System.out.println(currentCountPlayer);
                System.out.println("playerElo_"+eloPlay);
                System.out.println("minElo"+minEloTour);
                System.out.println("maxElo_"+maxEloTour);
                // to here
                return regisration;
            }

        }


        return regisration;
    }

}
