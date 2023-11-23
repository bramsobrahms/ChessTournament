package be.brahms.services.impl;

import be.brahms.enums.Status;
import be.brahms.exceptions.tournament.MoreThanMaxPlayerTournament;
import be.brahms.models.entities.TournamentEnt;
import be.brahms.repositories.TournamentRepo;
import be.brahms.services.TournamentServ;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TournamentServImpl implements TournamentServ {

    private final TournamentRepo tournamentRepo;

    public TournamentServImpl(TournamentRepo tournamentRepo) {
        this.tournamentRepo = tournamentRepo;
    }

    @Override
    public TournamentEnt create(TournamentEnt tournament) {
        if( tournament.getMinPlayer()> tournament.getMaxPlayer()){
            throw new MoreThanMaxPlayerTournament("trop de joueur");
        } else{
            LocalDate currentDate = LocalDate.now();
            Status currentStatus = Status.WAITING;
            int minimumPlayer = tournament.getMinPlayer();

            tournament.setCreateDateAt(currentDate);
            tournament.setEndDateAt(currentDate.plusDays(minimumPlayer));
            tournament.setUpdateDateAt(currentDate);
            tournament.setStatus(currentStatus);

            return tournamentRepo.save(tournament);
        }

    }
}
