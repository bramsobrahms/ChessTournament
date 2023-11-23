package be.brahms.models.dtos;

import be.brahms.enums.Category;
import be.brahms.models.entities.TournamentEnt;

public record TournamentDTO(
        Long id,
        String name,
        String place,
        int minPlayer,
        int maxPlayer,
        int minElo,
        int maxElo,
        Category category,
        boolean womenOnly
) {
    public TournamentDTO fromEntity(TournamentEnt tournament){
        return new TournamentDTO(tournament.getId(), tournament.getName(), tournament.getPlace(), tournament.getMinPlayer(), tournament.getMaxPlayer(), tournament.getMinElo(), tournament.getMaxElo(), tournament.getCategory(), tournament.isWomenOnly());
    }
}
