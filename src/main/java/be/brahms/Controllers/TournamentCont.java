package be.brahms.Controllers;

import be.brahms.models.dtos.TournamentDTO;
import be.brahms.models.entities.TournamentEnt;
import be.brahms.models.forms.TournamentF;
import be.brahms.services.TournamentServ;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @PutMapping("/{id}")
    public ResponseEntity<TournamentDTO> updateTournament(@PathVariable Long id, @RequestBody TournamentF form){
        TournamentEnt tournamentUpdate = tournamentServ.update(id, form.toEntity());
        return ResponseEntity.ok(TournamentDTO.fromEntity(tournamentUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTournament(@PathVariable Long id){
        tournamentServ.delete(id);
        return ResponseEntity.status(200).body("Deletion success");
    }

    @GetMapping("")
    public ResponseEntity<List<TournamentEnt>> listTournament() {
        List<TournamentEnt> tournaments = tournamentServ.findAllTournament()
                .stream()
                .sorted((dateNow, dateUpdate) -> dateUpdate.getUpdateDateAt().compareTo(dateNow.getCreateDateAt()))
                .limit(10)
                .collect(Collectors.toList());

        return ResponseEntity.ok(tournaments);
    }

    @GetMapping("/onlywomen")
    public ResponseEntity<List<TournamentEnt>> listTournamentOnlyWomen() {
        List<TournamentEnt> tournamentsWomen = tournamentServ.findAllTournamentOnlyWoment()
                .stream()
                .sorted((dateNow, dateUpdate) -> dateUpdate.getUpdateDateAt().compareTo(dateNow.getCreateDateAt()))
                .limit(10)
                .collect(Collectors.toList());

        return ResponseEntity.ok(tournamentsWomen);
    }
}
