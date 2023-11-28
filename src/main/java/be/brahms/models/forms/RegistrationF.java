package be.brahms.models.forms;

import be.brahms.models.entities.PlayerEnt;
import be.brahms.models.entities.RegistrationEnt;
import be.brahms.models.entities.TournamentEnt;
import lombok.Data;

@Data
public class RegistrationF {

    private PlayerEnt player;
    private TournamentEnt tournament;

    public RegistrationEnt toEntity() {
        return new RegistrationEnt(this.player, this.tournament);
    }
}
