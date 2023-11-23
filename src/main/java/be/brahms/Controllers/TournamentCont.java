package be.brahms.Controllers;

import be.brahms.models.entities.TournamentEnt;
import be.brahms.models.forms.TournamentF;
import be.brahms.services.TournamentServ;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tournament")
public class TournamentCont {

    @Autowired
    private final TournamentServ tournamentServ;

    public TournamentCont(TournamentServ tournamentServ) {
        this.tournamentServ = tournamentServ;
    }

    @PostMapping("/new")
    public ResponseEntity<TournamentEnt> create (@RequestBody @Valid TournamentF form) {
        TournamentEnt newTournament = tournamentServ.create(form.toEntity());
        return ResponseEntity.ok(newTournament);
    }
}
