package be.brahms.services.impl;

import be.brahms.enums.Status;
import be.brahms.exceptions.tournament.MoreThanMaxPlayerTournament;
import be.brahms.exceptions.tournament.NotFoundTournamentException;
import be.brahms.models.entities.TournamentEnt;
import be.brahms.repositories.TournamentRepo;
import be.brahms.services.TournamentServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TournamentServImpl implements TournamentServ {

    @Autowired
    private final TournamentRepo tournamentRepo;

    public TournamentServImpl(TournamentRepo tournamentRepo) {
        this.tournamentRepo = tournamentRepo;
    }

    @Override
    public TournamentEnt create(TournamentEnt tournament) {

        if (tournament.getMinPlayer() > tournament.getMaxPlayer()) {
            throw new MoreThanMaxPlayerTournament("trop de joueur");
        } else {
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

    @Override
    public TournamentEnt update(Long id, TournamentEnt tournament) {
        LocalDate currentDate = LocalDate.now();

        TournamentEnt tournamentUpdate = tournamentRepo.findById(id).orElseThrow(NotFoundTournamentException::new);
        tournamentUpdate.setName(tournament.getName());
        tournamentUpdate.setPlace(tournament.getPlace());
        tournamentUpdate.setUpdateDateAt(currentDate);

        return tournamentRepo.save(tournamentUpdate);
    }

    @Override
    public void delete(Long id) {
        TournamentEnt deleteTournament = tournamentRepo.findById(id).orElseThrow(NotFoundTournamentException::new);
        tournamentRepo.delete(deleteTournament);
    }

    @Override
    public List<TournamentEnt> findAllTournamentOnlyWoment() {
        return tournamentRepo.findAllTournamentOnlyWoment();
    }

    @Override
    public List<TournamentEnt> findAllTournament() {
        return tournamentRepo.findAll();
    }

    @Override
    public List<TournamentEnt> searchByData(String searchData){
        return tournamentRepo.searchByData(searchData);
    }

}
