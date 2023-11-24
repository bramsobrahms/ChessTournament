package be.brahms.services;

import be.brahms.models.entities.TournamentEnt;

import java.util.List;

public interface TournamentServ {

    TournamentEnt create(TournamentEnt tournament);
    TournamentEnt update(Long id, TournamentEnt tournament);
    void delete(Long id);
    List<TournamentEnt> findAllTournament();
    List<TournamentEnt> findAllTournamentOnlyWoment();
    List<TournamentEnt> searchByData(String searchData);

}
